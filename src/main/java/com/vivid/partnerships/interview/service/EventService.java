package com.vivid.partnerships.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.persistence.EventsDAO;

/**
 * The Class EventService.
 * 
 * @version 0.1
 */
@Service
public class EventService {

	/** The events DAO. */
	private final EventsDAO eventsDAO;

	/**
	 * Instantiates a new event service.
	 *
	 * @param eventsDAO the events DAO
	 */
	@Autowired
	public EventService(final EventsDAO eventsDAO) {

		this.eventsDAO = eventsDAO;
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public List<Event> getEvents() {

		return eventsDAO.findAll();
	}

	/**
	 * Saves a new event
	 *
	 * @param event the event
	 */
	public void save(final Event event) {

		eventsDAO.save(event);
	}
}
