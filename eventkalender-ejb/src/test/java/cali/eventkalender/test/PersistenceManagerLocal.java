package cali.eventkalender.test;

import javax.ejb.Local;

@Local
public interface PersistenceManagerLocal {

	void cleanDatabase();

}
