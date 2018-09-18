package com.vivid.partnerships.interview.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Represents an event api object
 * 
 * @version 0.1
 */
public class EventDTO {

	/** The name. */
	public String name;

	/** The date. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date date;

	/** The venue DTO. */
	public VenueDTO venueDTO;
}
