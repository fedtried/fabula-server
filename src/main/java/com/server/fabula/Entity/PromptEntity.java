package com.server.fabula.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "prompts")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PromptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<StoryEntity> stories;
}
