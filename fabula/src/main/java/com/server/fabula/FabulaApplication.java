package com.server.fabula;

import com.server.fabula.Stories.Stories;
import com.server.fabula.Stories.StoriesDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FabulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabulaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner (StoriesDAO storyDAO){
//		return runner -> {
////			createStory(storyDAO);
//			readStory(storyDAO);
//		};
//	}

}
