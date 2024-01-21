package com.server.fabula.Service;

import com.server.fabula.DAO.Request.SigninRequest;
import com.server.fabula.DAO.Request.SignUpRequest;
import com.server.fabula.DAO.Request.UpdateUserRequest;
import com.server.fabula.DAO.Response.JwtAuthenticationResponse;
import com.server.fabula.Entity.User;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

    User updateUser(UpdateUserRequest request);
}
