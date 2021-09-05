package com.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Story")
public class Story {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int storyId;
	private String storyTitle;
	private String storyText;
	
	public Story() {}
	
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public String getStoryTitle() {
		return storyTitle;
	}
	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}
	public String getStoryText() {
		return storyText;
	}
	public void setStoryText(String storyText) {
		this.storyText = storyText;
	}
	

}
