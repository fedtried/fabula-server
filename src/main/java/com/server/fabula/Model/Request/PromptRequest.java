package com.server.fabula.Model.Request;

import com.server.fabula.Entity.Mode;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptRequest {

    private LocalDate date;
    private String quote;
    private Mode mode;
}
