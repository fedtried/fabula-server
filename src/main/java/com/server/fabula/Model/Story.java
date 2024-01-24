package com.server.fabula.Model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
