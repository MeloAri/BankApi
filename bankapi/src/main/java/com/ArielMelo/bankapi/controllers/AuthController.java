package com.ArielMelo.bankapi.controllers;

import com.ArielMelo.bankapi.dtos.LoginRequest;
import com.ArielMelo.bankapi.dtos.RegisterRequest;
import com.ArielMelo.bankapi.dtos.TokenResponse;
import com.ArielMelo.bankapi.entities.User;
import com.ArielMelo.bankapi.enums.Role;
import com.ArielMelo.bankapi.repositories.UserRepository;
import com.ArielMelo.bankapi.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(
            @RequestBody LoginRequest request) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(), request.password())
        );

        String token = jwtService.generateToken(request.email());

        return ResponseEntity.ok(new TokenResponse(token));
    }

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setCpf(request.cpf());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);

        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }
}
