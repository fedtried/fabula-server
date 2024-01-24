package com.server.fabula.Controller;

import static org.springframework.http.ResponseEntity.ok;

import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Model.Request.StoryRequest;
import com.server.fabula.Model.Story;
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
    public ResponseEntity<Story> createStory(@RequestBody StoryRequest storyRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(StoryService.createStory(storyRequest));
    }

    @PutMapping("/story")
    public ResponseEntity<Story> updateStory(@RequestBody StoryEntity storyEntity){
        return ok(StoryService.updateStory(storyEntity));
    }

    @DeleteMapping("/story/{id}")
    public ResponseEntity<Story> deleteStory(@PathVariable int id) {
        return ok(StoryService.deleteStory(id));
    }

    @GetMapping("/story/date/{date}")
    public ResponseEntity<List<Story>> getStoryByDate(@PathVariable LocalDate date){
        List<Story> allStories = StoryService.findStoriesByDate(date);

        // Filter stories where share is true
        return ResponseEntity.ok(allStories.stream().filter(Story::getShare ).toList());
    }
}
