package com.server.fabula.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class StoryEntity {

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

    @Column(name = "share")
    private Boolean share;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "prompt_id")
    @JsonIgnore
    private PromptEntity prompt;

}
