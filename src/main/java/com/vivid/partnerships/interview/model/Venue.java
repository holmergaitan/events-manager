package com.vivid.partnerships.interview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a Venue in the system
 * 
 * @version 0.1
 */
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venues")
public class Venue {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/** The name. */
	@NotBlank
	@Column(name = "name")
	private String name;

	/** The city. */
	@NotBlank
	@Column(name = "city")
	private String city;

	/** The state. */
	@NotBlank
	@Column(name = "state")
	private String state;
}
