package com.server.fabula.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="stories")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Story {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "quote")
    private String quote;

    @Column(name = "writing")
    private String writing;

}
