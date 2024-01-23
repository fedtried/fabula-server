package com.server.fabula.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    private Integer id;
    private String name;
    private String email;
    private String currentPassword;
    private String newPassword;
}
