package com.server.fabula.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name="modes")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Mode {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private int mode_id;
    @Column(name = "mode_name")
    private String mode_name;
}
