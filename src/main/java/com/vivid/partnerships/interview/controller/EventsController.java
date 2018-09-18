package com.vivid.partnerships.interview.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.partnerships.interview.converter.EventApiToEventModelConverter;
import com.vivid.partnerships.interview.converter.EventModelToEventApi;
import com.vivid.partnerships.interview.dto.EventDTO;
import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.service.EventService;

/**
 * Manage requests related to Events resources
 * 
 * @version 0.1
 */
@RestController
@RequestMapping("/events")
public class EventsController {
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(EventsController.class);

    /** The event service. */
    private final EventService eventService;
    
    private final EventApiToEventModelConverter modelConverter;
    
    private final EventModelToEventApi apiConverter;

    /**
     * Instantiates a new event controller.
     *
     * @param eventService the event service
     */
    @Autowired
    public EventsController(
    		final EventService eventService, 
    		final EventApiToEventModelConverter modelConverter, 
    		final EventModelToEventApi apiConverter) {
    	
        this.eventService = eventService;
        this.modelConverter = modelConverter;
        this.apiConverter = apiConverter;
    }

    /**
     * Gets all events
     *
     * @return the events
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<EventDTO> getEvents() {
    	
        List<Event> events = eventService.getEvents();
        final List<EventDTO> convertedEvents = events
        		.stream()
        		.map(a ->  apiConverter.convert(a))
        		.collect(Collectors.toList());
        
        LOGGER.info("Returning {} events", convertedEvents.size());
        return convertedEvents;
    }
    
    /**
     * Creates a new event
     *
     * @param event the event
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> newEvent(@RequestBody final EventDTO source) {
    	
    	final Event event = modelConverter.convert(source);
    	eventService.save(event);
    	return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}