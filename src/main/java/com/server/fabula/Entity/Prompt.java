package com.server.fabula.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="prompts")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Prompt {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "quote")
    private String quote;

    @Column(name = "mode")
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @OneToMany(mappedBy = "prompt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("prompt")
    private List<Story> stories;
}
