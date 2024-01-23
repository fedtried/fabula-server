package com.server.fabula.Service;

import com.server.fabula.DAO.Request.SignInRequest;
import com.server.fabula.DAO.Request.SignUpRequest;
import com.server.fabula.DAO.Request.UpdateUserRequest;
import com.server.fabula.DAO.Response.JwtAuthenticationResponse;
import com.server.fabula.Entity.UserEntity;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);

    UserEntity updateUser(UpdateUserRequest request);
}
