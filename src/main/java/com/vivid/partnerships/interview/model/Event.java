package com.vivid.partnerships.interview.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents an Event in the system
 * 
 * @version 0.1
 */
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	/** The name. */
	@NotBlank
	@Column(name = "name")
	public String name;

	/** The date. */
	@NotNull
	@Column(name = "date")
	public Date date;

	/** The venue. */
	@OneToOne(
			cascade = {CascadeType.ALL}, 
			orphanRemoval = true, 
			fetch = FetchType.EAGER)
	public Venue venue;
}
