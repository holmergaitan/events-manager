package com.vivid.partnerships.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {

	private String name;

	private String city;

	private String state;
}
