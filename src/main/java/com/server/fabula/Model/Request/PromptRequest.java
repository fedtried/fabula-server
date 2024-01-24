package com.server.fabula.Model.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.fabula.Entity.Mode;
import com.server.fabula.Entity.StoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptRequest {

    private LocalDate date;
    private String quote;
    private Mode mode;

}
