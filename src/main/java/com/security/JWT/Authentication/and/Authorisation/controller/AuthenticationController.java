package com.security.JWT.Authentication.and.Authorisation.controller;

import com.security.JWT.Authentication.and.Authorisation.dao.request.SigninRequest;
import com.security.JWT.Authentication.and.Authorisation.dao.request.SignupRequest;
import com.security.JWT.Authentication.and.Authorisation.dao.response.JwtAuthenticationResponse;
import com.security.JWT.Authentication.and.Authorisation.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signing(@RequestBody SigninRequest request){
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
