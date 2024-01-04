package com.server.fabula.Controller;

import static org.springframework.http.ResponseEntity.ok;

import com.server.fabula.Entity.Story;
import com.server.fabula.Service.StoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StoryController {
    private final com.server.fabula.Service.StoryService StoryService;
    public StoryController(StoryService StoryService){
        this.StoryService = StoryService;
    }
    @GetMapping("/Story")
    public List<Story> getAllStories(){
        return StoryService.findAll();
    }

    @GetMapping("/Story/{id}")
    public ResponseEntity<Story> getStoryById(@PathVariable int id){
        return ok(StoryService.findStoryById(id));
    }

    @PostMapping("/Story")
    public ResponseEntity<Story> addStory(@RequestBody Story story){
        story.setId(0);
        return ok(StoryService.saveStory(story));
    }

    @PutMapping("/Story")
    public ResponseEntity<Story> updateStory(@RequestBody Story story){
        return ok(StoryService.saveStory(story));
    }

    @DeleteMapping("/Story/{id}")
    public ResponseEntity<Story> deleteStory(@PathVariable int id) {
        return ok(StoryService.deleteStory(id));
    }

}
