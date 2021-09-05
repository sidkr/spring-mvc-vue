package com.rest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.DAO.StoryDAO;
import com.rest.model.Story;
import com.rest.service.StoryService;

@Service
@Transactional
public class StoryServiceImpl implements StoryService{

	@Autowired StoryDAO dao;
	
	public Story getStory(int storyId) {
		return dao.getStory(storyId);
	}

	@Transactional
	public Story postStory(Story story) {
		return dao.postStory(story);
	}

	@Transactional
	public Story upateStory(Story story) {
		return dao.upateStory(story);
	}

	@Transactional
	public void deleteStory(int storyId) {
		dao.deleteStory(storyId);
	}

	public List<Story> getStories() {
		return dao.getStories();
	}

}
