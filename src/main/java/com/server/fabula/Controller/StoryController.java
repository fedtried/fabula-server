package com.server.fabula.Controller;

import static org.springframework.http.ResponseEntity.ok;

import com.server.fabula.Entity.StoryEntity;
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
    public List<StoryEntity> getAllStories(){
        return StoryService.findAll();
    }

    @GetMapping("/story/{id}")
    public ResponseEntity<StoryEntity> getStoryById(@PathVariable int id){
        return ok(StoryService.findStoryById(id));
    }

    @PostMapping("/story")
    public ResponseEntity<StoryEntity> addStory(@RequestBody StoryEntity storyEntity, @RequestParam(name = "userId") int userId, @RequestParam(name = "promptId") int promptId){
        storyEntity.setId(0);
        StoryEntity savedStoryEntity = StoryService.saveStory(storyEntity, userId, promptId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStoryEntity);
    }

    @PutMapping("/story")
    public ResponseEntity<StoryEntity> updateStory(@RequestBody StoryEntity storyEntity){
        return ok(StoryService.updateStory(storyEntity));
    }

    @DeleteMapping("/story/{id}")
    public ResponseEntity<StoryEntity> deleteStory(@PathVariable int id) {
        return ok(StoryService.deleteStory(id));
    }

    @GetMapping("/story/date/{date}")
    public ResponseEntity<List<StoryEntity>> getStoryByDate(@PathVariable LocalDate date){
        List<StoryEntity> allStories = StoryService.findStoryByDate(date);

        // Filter stories where share is true
        List<StoryEntity> sharedStories = allStories.stream()
                .filter(StoryEntity::isShare)
                .collect(Collectors.toList());

        return ResponseEntity.ok(sharedStories);
    }
}
