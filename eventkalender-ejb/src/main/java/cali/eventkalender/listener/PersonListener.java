package cali.eventkalender.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cali.eventkalender.model.Person;

public class PersonListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonListener.class);
	
	@PrePersist
	public void prePersist(Person person) {
		LOGGER.info("PrePersist - {} {}", person.getFirstName(), person.getLastName());
	}

	@PostPersist
	public void postPersist(Person person) {
		LOGGER.info("PostPersist - {} {}", person.getFirstName(), person.getLastName());
	}

	@PostLoad
	public void postLoad(Person person) {
		LOGGER.info("PostLoad - {} {}", person.getFirstName(), person.getLastName());
	}

	@PreUpdate
	public void preUpdate(Person person) {
		LOGGER.info("PreUpdate - {} {}", person.getFirstName(), person.getLastName());
	}

	@PostUpdate
	public void postUpdate(Person person) {
		LOGGER.info("PostUpdate - {} {}", person.getFirstName(), person.getLastName());
	}

	@PreRemove
	public void preRemove(Person person) {
		LOGGER.info("PreRemove - {} {}", person.getFirstName(), person.getLastName());
	}

	@PostRemove
	public void postRemove(Person person) {
		LOGGER.info("PostRemove - {} {}", person.getFirstName(), person.getLastName());
	}
	
}
