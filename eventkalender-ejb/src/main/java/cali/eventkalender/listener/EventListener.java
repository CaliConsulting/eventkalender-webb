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

import cali.eventkalender.model.Event;

public class EventListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventListener.class);
	
	@PrePersist
	public void prePersist(Event event) {
		LOGGER.info("PrePersist - {}", event.getName());
	}

	@PostPersist
	public void postPersist(Event event) {
		LOGGER.info("PostPersist - {}", event.getName());
	}

	@PostLoad
	public void postLoad(Event event) {
		LOGGER.info("PostLoad - {}", event.getName());
	}

	@PreUpdate
	public void preUpdate(Event event) {
		LOGGER.info("PreUpdate - {}", event.getName());
	}

	@PostUpdate
	public void postUpdate(Event event) {
		LOGGER.info("PostUpdate - {}", event.getName());
	}

	@PreRemove
	public void preRemove(Event event) {
		LOGGER.info("PreRemove - {}", event.getName());
	}

	@PostRemove
	public void postRemove(Event event) {
		LOGGER.info("PostRemove - {}", event.getName());
	}
	
}
