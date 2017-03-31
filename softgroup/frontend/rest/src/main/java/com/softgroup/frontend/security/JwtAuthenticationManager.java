package com.softgroup.frontend.security;

import com.softgroup.common.protocol.Credential;
import com.softgroup.common.token.JwtToken;
import com.softgroup.common.token.JwtTokenPayload;
import com.softgroup.common.token.JwtTokenStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthentication jwtAuthentication = (JwtAuthentication) authentication;
        jwtAuthentication.setAuthenticated(false);

        String token = jwtAuthentication.getToken();
        if ( token != null & isValidToken(token) ) {
            Credential credential = createCredentialFromToken(token);
            jwtAuthentication = new JwtAuthentication(credential);
            jwtAuthentication.setAuthenticated(true);
        }

        return jwtAuthentication;
    }

    private boolean isValidToken(String token) {
        return (JwtToken.validateToken(token) == JwtTokenStatus.TOKEN_VALID);
    }

    private Credential createCredentialFromToken(String token) {
        JwtTokenPayload jwtTokenPayload =
                JwtToken.parser().getJwtTokenPayload(token);

        String deviceId = jwtTokenPayload.getDeviceId();
        String userId = jwtTokenPayload.getUserId();

        return new Credential(deviceId, userId);
    }

}
