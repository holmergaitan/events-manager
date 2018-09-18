package com.vivid.partnerships.interview.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.vivid.partnerships.interview.dto.EventDTO;
import com.vivid.partnerships.interview.dto.VenueDTO;
import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

/**
 * Converts from {@link EventDTO} to {@link Event}.
 * 
 * @version 0.1
 */
@Component
public class EventApiToEventModelConverter implements Converter<EventDTO, Event>{


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Event convert(final EventDTO source) {
		
		final VenueDTO venueDTO = source.getVenueDTO();
		final Venue venue = Venue.builder()
				.city(venueDTO.getCity())
				.name(venueDTO.getName())
				.state(venueDTO.getState())
				.build();
		
		final Event event = 
				Event.builder()
				.name(source.getName())
				.date(source.getDate())
				.venue(venue)
				.build();
		
		return event;
	}
}
