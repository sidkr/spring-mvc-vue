package com.rest.story.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Story;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TestController {
	
	private static final Logger logger = Logger.getLogger(TestController.class);

	
	@GetMapping("/message")
	public ResponseEntity<?> getMessage() {
		Story s1 = new Story();
		s1.setStoryTitle("Hello World...");
		s1.setStoryText("..this is my story..");
		logger.info(" >>> getMessage test ");

		return ResponseEntity.ok().body(s1);
	}

}
