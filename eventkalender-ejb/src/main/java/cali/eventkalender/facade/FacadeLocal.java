package cali.eventkalender.facade;

import javax.ejb.Local;

import cali.eventkalender.model.Nation;

@Local
public interface FacadeLocal {

	Nation findByNationId(long id);
	
}
