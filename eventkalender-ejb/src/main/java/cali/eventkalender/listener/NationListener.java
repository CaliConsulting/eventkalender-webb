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

import cali.eventkalender.model.Nation;

public class NationListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NationListener.class);
	
	@PrePersist
	public void prePersist(Nation nation) {
		LOGGER.info("PrePersist - {}", nation.getName());
	}

	@PostPersist
	public void postPersist(Nation nation) {
		LOGGER.info("PostPersist - {}", nation.getName());
	}

	@PostLoad
	public void postLoad(Nation nation) {
		LOGGER.info("PostLoad - {}", nation.getName());
	}

	@PreUpdate
	public void preUpdate(Nation nation) {
		LOGGER.info("PreUpdate - {}", nation.getName());
	}

	@PostUpdate
	public void postUpdate(Nation nation) {
		LOGGER.info("PostUpdate - {}", nation.getName());
	}

	@PreRemove
	public void preRemove(Nation nation) {
		LOGGER.info("PreRemove - {}", nation.getName());
	}

	@PostRemove
	public void postRemove(Nation nation) {
		LOGGER.info("PostRemove - {}", nation.getName());
	}
	
}
