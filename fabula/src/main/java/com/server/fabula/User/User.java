package com.server.fabula.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="users")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
