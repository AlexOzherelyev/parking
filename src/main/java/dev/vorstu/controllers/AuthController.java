package dev.vorstu.controllers;

import dev.vorstu.dto.auth.JwtAuthenticationResponse;
import dev.vorstu.dto.auth.SignInRequest;
import dev.vorstu.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/login")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationService authenticationService;
    @PostMapping
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }

}
