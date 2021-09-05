package com.rest.story.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Story;
import com.rest.service.StoryService;

@RestController
@CrossOrigin(origins = "*")
public class StoryController {

	@Autowired StoryService service;
	
	//Add a new story
	@PostMapping("/story")
	public ResponseEntity<?> postStory(@RequestBody Story story){
		service.postStory(story);
		return ResponseEntity.ok().body(story);
	}
	
	@GetMapping("/story/{storyId}")
	public ResponseEntity<?> getStory(@PathVariable("storyId") int storyId) {
//		Story story = service.getStory(storyId);
		 Story s1 = new Story();
   	  s1.setStoryText("Dummy story # 1");
   	  s1.setStoryTitle("Dummy Story Title #1 ");
		return ResponseEntity.ok().body(s1);
	}
	
	@PutMapping("/story/{storyId}")
	public ResponseEntity<?> updateStory(@PathVariable("storyId") int storyId, @RequestBody Story story){
		Story story2 = service.upateStory(story);
		return ResponseEntity.ok().body(story2);
	}
	
	@DeleteMapping("/story/{storyId}")
	public ResponseEntity<?> deleteStory(@PathVariable("storyId") int storyId) {
		service.deleteStory(storyId);
		return ResponseEntity.ok("Story deleted with Id:" + storyId);
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/story")
	   public ResponseEntity<List<Story>> getStories() {
	      List<Story> stories = service.getStories();
	      
	      if(CollectionUtils.isEmpty(stories)) {
	    	  
	    	  stories = new ArrayList<Story>();
	    	  
	    	  Story s1 = new Story();
	    	  s1.setStoryText("Dummy story # 1");
	    	  s1.setStoryTitle("Dummy Story Title #1 ");
	    	  s1.setStoryId(1);
	    	  
	    	  Story s2 = new Story();
	    	  s2.setStoryText("Dummy story # 1");
	    	  s2.setStoryTitle("Dummy Story Title #1 ");
	    	  s2.setStoryId(1);
	    	  
	    	  stories.add(s1);
	    	  stories.add(s2);
	    	  
	      }
	      
	      
	      return ResponseEntity.ok().body(stories);
	   }
	
}
