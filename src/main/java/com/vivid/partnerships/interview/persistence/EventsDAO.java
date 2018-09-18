package com.vivid.partnerships.interview.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vivid.partnerships.interview.model.Event;

/**
 * Manage all persistence operations related to {@link Event}}
 * 
 * @version 0.1
 */
public interface EventsDAO extends CrudRepository<Event, Integer> {

	/**
	 * {@inheritDoc}
	 */
	List<Event> findAll();
}
