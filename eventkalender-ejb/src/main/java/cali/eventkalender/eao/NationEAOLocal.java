package cali.eventkalender.eao;

import javax.ejb.Local;

import cali.eventkalender.model.Nation;

@Local
public interface NationEAOLocal {

	Nation add(Nation nation);
	
	void delete(long id);
	
	Nation findById(long id);
	
	Nation update(Nation nation);
	
}
