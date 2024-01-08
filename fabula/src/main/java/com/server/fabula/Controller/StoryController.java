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
    public ResponseEntity<Story> addStory(@RequestBody Story story, @RequestParam(name = "id") int id){
        story.setId(0);
        return ok(StoryService.saveStory(story, id));
    }

    @PutMapping("/story")
    public ResponseEntity<Story> updateStory(@RequestBody Story story){
        return ok(StoryService.updateStory(story));
    }

    @DeleteMapping("/story/{id}")
    public ResponseEntity<Story> deleteStory(@PathVariable int id) {
        return ok(StoryService.deleteStory(id));
    }

}
