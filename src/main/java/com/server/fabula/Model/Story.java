package com.server.fabula.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {
    private int id;
    private LocalDate date;
    private String quote;
    private String writing;
    private Boolean share;
}