package com.server.fabula.Entity;

import jakarta.persistence.*;
import lombok.*;

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
    private String date;

    @Column(name = "quote")
    private String quote;
}
