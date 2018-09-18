package com.vivid.partnerships.interview.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.vivid.partnerships.interview.dto.EventDTO;
import com.vivid.partnerships.interview.dto.VenueDTO;
import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

@Component
public class EventModelToEventApi implements Converter<Event, EventDTO> {

	@Override
	public EventDTO convert(final Event source) {
		
		final Venue venue = source.getVenue();
		final VenueDTO venueDTO = VenueDTO.builder()
				.city(venue.getCity())
				.name(venue.getName())
				.state(venue.getState())
				.build();
		
		final EventDTO eventDTO = 
				EventDTO.builder()
				.name(source.getName())
				.date(source.getDate())
				.venueDTO(venueDTO)
				.build();
		
		return eventDTO;
	}
}
