package com.server.fabula.Service;

import com.server.fabula.Model.Request.SignInRequest;
import com.server.fabula.Model.Request.SignUpRequest;
import com.server.fabula.Model.Request.UpdateUserRequest;
import com.server.fabula.Model.Response.JwtAuthenticationResponse;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.User;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);

    User updateUser(UpdateUserRequest updateUserRequest);
}
