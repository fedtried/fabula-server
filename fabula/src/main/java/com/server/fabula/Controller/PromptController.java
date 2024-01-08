package com.server.fabula.Controller;

import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;
import com.server.fabula.Service.PromptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping("/prompt/{date}")
    public ResponseEntity<Prompt> getStoryByDate(@PathVariable String date){
        return ok(promptService.findStoryByDate(date));
    }

    @PostMapping("/prompt")
    public ResponseEntity<Prompt> savePrompt(@RequestBody Prompt prompt){
        return ok(promptService.savePrompt(prompt));
    }
}
