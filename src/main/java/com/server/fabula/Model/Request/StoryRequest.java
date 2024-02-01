package com.server.fabula.Model.Request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
