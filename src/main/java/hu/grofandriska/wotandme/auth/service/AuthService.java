package hu.grofandriska.wotandme.auth.service;

import hu.grofandriska.wotandme.api.model.account.AccountSearchResponse;
import hu.grofandriska.wotandme.api.model.account.AccountSearchResponseData;
import hu.grofandriska.wotandme.api.service.PlayerService;
import hu.grofandriska.wotandme.auth.model.AppUser;
import hu.grofandriska.wotandme.auth.model.Role;
import hu.grofandriska.wotandme.auth.model.dto.AuthRequest;
import hu.grofandriska.wotandme.auth.model.dto.AuthResponse;
import hu.grofandriska.wotandme.auth.model.dto.RegistrationRequest;
import hu.grofandriska.wotandme.auth.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AppUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final PlayerService playerService;

    public AuthResponse register(RegistrationRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Email already exists");
        }

        AccountSearchResponse response = playerService.searchPlayer(request.nickname());


        for (AccountSearchResponseData data : response.getAccountList()) {
            if (data.getNickname().equals(request.nickname())) {
                AppUser user = createUser(request, data);

                return new AuthResponse(jwtService.generateToken(
                        new User(
                                user.getEmail(),
                                user.getPassword(),
                                List.of()
                        )
                ));
            }
        }

        throw new HttpClientErrorException(
                HttpStatus.NOT_FOUND,
                "Player " + request.nickname() + " not found in WoT API"
        );
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        AppUser user = userRepository.findByEmail(request.email()).orElseThrow();

        String token = jwtService.generateToken(new User(
                user.getEmail(),
                user.getPassword(),
                List.of()
        ));
        return new AuthResponse(token);
    }

    private AppUser createUser(RegistrationRequest request, AccountSearchResponseData response) {
        AppUser user = new AppUser();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);
        user.setNickname(response.getNickname());
        user.setAccountId(response.getId());

        return userRepository.save(user);
    }
}
