package com.vivid.partnerships.interview;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;
import com.vivid.partnerships.interview.persistence.EventsDAO;

/**
 * Sets up the application
 * 
 * @version 0.1
 */
@SpringBootApplication
public class InterviewApplication implements CommandLineRunner {
	
	/** The events DAO. */
	@Autowired 
	private EventsDAO eventsDAO;
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(InterviewApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(InterviewApplication.class, args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(String... strings) throws Exception {
		
		log.info("Creating events table");
		final Venue venue = Venue.builder()
				.city("Chicago")
				.name("Wrigley Field")
				.state("IL")
				.build();
		
		final Event event = Event.builder()
				.name("Chicago White Sox vs. Chicago Cubs")
				.date(new Date())
				.venue(venue)
				.build();
		
		eventsDAO.save(event);
	}
}
