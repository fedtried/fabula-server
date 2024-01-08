package com.server.fabula.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.fabula.DTO.PromptDTO;
import com.server.fabula.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="stories")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Story {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "quote")
    private String quote;

    @Column(name = "writing")
    private String writing;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "prompt_id")
    @JsonIgnore
    private Prompt prompt;
}
