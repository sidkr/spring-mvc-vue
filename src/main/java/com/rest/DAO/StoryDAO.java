package com.rest.DAO;

import java.util.List;

import com.rest.model.Story;

public interface StoryDAO {
	
	public Story getStory(int storyId);
	public Story postStory(Story story);
	public Story upateStory(Story story);
	public void deleteStory(int storyId);
	public List<Story> getStories();

}
