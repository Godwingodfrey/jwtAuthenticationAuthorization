package com.security.JWT.Authentication.and.Authorisation.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
}
