package com.server.fabula.Controller;

import static org.springframework.http.ResponseEntity.ok;

import com.server.fabula.Entity.Story;
import com.server.fabula.Service.StoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StoryController {

    private final StoryService StoryService;


    public StoryController(StoryService StoryService){
        this.StoryService = StoryService;
    }
    @GetMapping("/story")
    public List<Story> getAllStories(){
        return StoryService.findAll();
    }

    @GetMapping("/story/{id}")
    public ResponseEntity<Story> getStoryById(@PathVariable int id){
        return ok(StoryService.findStoryById(id));
    }

    @PostMapping("/story")
    public ResponseEntity<Story> addStory(@RequestBody Story story, @RequestParam(name = "userId") int userId, @RequestParam(name = "promptId") int promptId){
        story.setId(0);
        Story savedStory = StoryService.saveStory(story, userId, promptId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStory);
    }

    @PutMapping("/story")
    public ResponseEntity<Story> updateStory(@RequestBody Story story){
        return ok(StoryService.updateStory(story));
    }

    @DeleteMapping("/story/{id}")
    public ResponseEntity<Story> deleteStory(@PathVariable int id) {
        return ok(StoryService.deleteStory(id));
    }

    @GetMapping("/story/date/{date}")
    public ResponseEntity<List<Story>> getStoryByDate(@PathVariable LocalDate date){
        List<Story> allStories = StoryService.findStoryByDate(date);

        // Filter stories where share is true
        List<Story> sharedStories = allStories.stream()
                .filter(Story::isShare)
                .collect(Collectors.toList());

        return ResponseEntity.ok(sharedStories);
    }
}
