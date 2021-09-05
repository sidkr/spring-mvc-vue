package com.rest.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.DAO.StoryDAO;
import com.rest.model.Story;

@Repository
public class StoryDAOImpl implements StoryDAO {
	
	@Autowired SessionFactory sessionFactory;

	public Story getStory(int storyId) {
		return sessionFactory.getCurrentSession().get(Story.class, storyId);
	}

	public Story postStory(Story story) {
		sessionFactory.getCurrentSession().save(story);
		return story;
	}

	public Story upateStory(Story story) {
		Story s = sessionFactory.getCurrentSession().get(Story.class, story.getStoryId());
		s.setStoryText(story.getStoryText());
		s.setStoryTitle(story.getStoryTitle());
		sessionFactory.getCurrentSession().update(s);
		return story;
	}

	public void deleteStory(int storyId) {
		Story story = sessionFactory.getCurrentSession().load(Story.class, storyId);
		sessionFactory.getCurrentSession().delete(story);
		
	}

	@SuppressWarnings("deprecation")
	public List<Story> getStories() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Story.class);
		return criteria.list();
	}

	
}
