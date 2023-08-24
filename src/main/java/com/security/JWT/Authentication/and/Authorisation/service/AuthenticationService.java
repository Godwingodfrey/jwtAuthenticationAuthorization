package com.security.JWT.Authentication.and.Authorisation.service;

import com.security.JWT.Authentication.and.Authorisation.dao.request.SigninRequest;
import com.security.JWT.Authentication.and.Authorisation.dao.request.SignupRequest;
import com.security.JWT.Authentication.and.Authorisation.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignupRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}
