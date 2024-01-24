package com.server.fabula.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoryRequest {

    private int userId;
    private int promptId;
    private LocalDate date;
    private String quote;
    private String writing;
    private Boolean share;
}
