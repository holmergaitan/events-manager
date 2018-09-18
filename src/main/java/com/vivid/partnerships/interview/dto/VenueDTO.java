package com.vivid.partnerships.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Represents a Venue api object
 * 
 * @version 0.1
 */
public class VenueDTO {

	/** The name. */
	private String name;

	/** The city. */
	private String city;

	/** The state. */
	private String state;
}
