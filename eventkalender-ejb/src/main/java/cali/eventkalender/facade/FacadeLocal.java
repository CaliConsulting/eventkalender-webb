package cali.eventkalender.facade;

import java.util.List;

import javax.ejb.Local;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.model.Person;

@Local
public interface FacadeLocal {

	Event addEvent(Event event);
	
	Nation addNation(Nation nation);
	
	Person addPerson(Person person);
	
	void deleteEvent(long id);
	
	void deleteNation(long id);
	
	void deletePerson(long id);
	
	List<Event> findAllEvents();
	
	List<Nation> findAllNations();
	
	List<Person> findAllPersons();
	
	Event findEventById(long id);
	
	Nation findNationById(long id);
	
	Person findPersonById(long id);
	
	Event updateEvent(Event event);
	
	Nation updateNation(Nation nation);
	
	Person updatePerson(Person person);
	
}
