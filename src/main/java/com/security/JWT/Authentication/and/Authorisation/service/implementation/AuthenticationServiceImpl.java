package com.security.JWT.Authentication.and.Authorisation.service.implementation;

import com.security.JWT.Authentication.and.Authorisation.dao.request.SigninRequest;
import com.security.JWT.Authentication.and.Authorisation.dao.request.SignupRequest;
import com.security.JWT.Authentication.and.Authorisation.dao.response.JwtAuthenticationResponse;
import com.security.JWT.Authentication.and.Authorisation.entity.User;
import com.security.JWT.Authentication.and.Authorisation.enums.Role;
import com.security.JWT.Authentication.and.Authorisation.repository.UserRepository;
import com.security.JWT.Authentication.and.Authorisation.service.AuthenticationService;
import com.security.JWT.Authentication.and.Authorisation.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignupRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
