package com.server.fabula.Controller;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.Request.PromptRequest;
import com.server.fabula.Service.PromptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping("/prompt/{date}")
    public ResponseEntity<Prompt> getStoryByDate(@PathVariable LocalDate date){
        return ok(promptService.findStoryByDate(date));
    }

    @PostMapping("/prompt")
    public ResponseEntity<Prompt> savePrompt(@RequestBody PromptRequest promptRequest){
        return ok(promptService.savePrompt(promptRequest));
    }
}
