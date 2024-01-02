package com.server.fabula.Stories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoriesController {
    private StoriesService storiesService;

    @Autowired
    public StoriesController(StoriesService storiesService) {
        this.storiesService = storiesService;
    }

    @PostConstruct
    public void loadData(){

    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello There";
    }

    @GetMapping("/stories")
    public List<Stories> getAllStories(){
        return storiesService.findAll();
    }

    @GetMapping("/stories/{id}")
    public Stories getStoryById(@PathVariable int id){
        Stories story = storiesService.findStoryById(id);
        if (story == null){
            throw new RuntimeException("Story not found!");
        }
        return story;
    }

    @PostMapping("/stories")
    public Stories addStory(@RequestBody Stories story){
        story.setId(0);
        try {
            return storiesService.saveStory(story);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/stories")
    public Stories updateStory(@RequestBody Stories story){
        try {
            return storiesService.saveStory(story);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/stories/{id}")
    public String deleteStory(@PathVariable int id) {
        Stories story = storiesService.findStoryById(id);
        if (story == null){
            throw new RuntimeException("Story not found!");
        }
        storiesService.deleteStoryById(id);
        return "Deleted story";
    }

}
