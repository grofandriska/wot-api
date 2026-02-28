package hu.grofandriska.wotandme.auth.service;

import hu.grofandriska.wotandme.auth.model.AppUser;
import hu.grofandriska.wotandme.auth.model.Role;
import hu.grofandriska.wotandme.auth.model.dto.AuthRequest;
import hu.grofandriska.wotandme.auth.model.dto.AuthResponse;
import hu.grofandriska.wotandme.auth.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRequest request){

        if (userRepository.existsByEmail(request.email())){
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"Email already exists");
        }
        AppUser user = new AppUser();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);

        userRepository.save(user);

        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        List.of()
                )
        );
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(),request.password()));
        AppUser user = userRepository.findByEmail(request.email()).orElseThrow();

        String token = jwtService.generateToken(new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of()
        ));
        return new AuthResponse(token);
    }
}
