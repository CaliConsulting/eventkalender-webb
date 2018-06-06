package cali.eventkalender.eao;

import java.util.List;

import javax.ejb.Local;

import cali.eventkalender.model.Nation;

@Local
public interface NationEAOLocal {

	Nation add(Nation nation);

	void delete(long id);

	List<Nation> findAll();

	Nation findById(long id);

	Nation update(Nation nation);

}
