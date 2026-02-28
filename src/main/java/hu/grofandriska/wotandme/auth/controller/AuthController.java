package hu.grofandriska.wotandme.auth.controller;


import hu.grofandriska.wotandme.auth.model.dto.AuthRequest;
import hu.grofandriska.wotandme.auth.model.dto.AuthResponse;
import hu.grofandriska.wotandme.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registration")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @GetMapping("/testing")
    public String test(){
        return "Hello World";
    }
}
