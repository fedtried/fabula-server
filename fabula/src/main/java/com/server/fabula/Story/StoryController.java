package com.server.fabula.Story;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoryController {
    private final StoryService StoryService;
    public StoryController(StoryService StoryService){
        this.StoryService = StoryService;
    }
    @PostConstruct
    public void loadData(){

    }

    @GetMapping("/Story")
    public List<Story> getAllStory(){
        return StoryService.findAll();
    }

    @GetMapping("/Story/{id}")
    public Story getStoryById(@PathVariable int id){
        Story story = StoryService.findStoryById(id);
        if (story == null){
            throw new RuntimeException("Story not found!");
        }
        return story;
    }

    @PostMapping("/Story")
    public Story addStory(@RequestBody Story story){
        story.setId(0);
        try {
            return StoryService.saveStory(story);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/Story")
    public Story updateStory(@RequestBody Story story){
        try {
            return StoryService.saveStory(story);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/Story/{id}")
    public String deleteStory(@PathVariable int id) {
        Story story = StoryService.findStoryById(id);
        if (story == null){
            throw new RuntimeException("Story not found!");
        }
        StoryService.deleteStoryById(id);
        return "Deleted story";
    }

}
