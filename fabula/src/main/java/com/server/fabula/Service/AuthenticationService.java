package com.server.fabula.Service;

import com.server.fabula.DAO.Request.SigninRequest;
import com.server.fabula.DAO.Request.SignUpRequest;
import com.server.fabula.DAO.Response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
