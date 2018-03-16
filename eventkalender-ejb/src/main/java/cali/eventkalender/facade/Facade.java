package cali.eventkalender.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import cali.eventkalender.eao.EventEAOLocal;
import cali.eventkalender.eao.NationEAOLocal;
import cali.eventkalender.eao.PersonEAOLocal;
import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.model.Person;

@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private EventEAOLocal eventEAO;

	@EJB
	private NationEAOLocal nationEAO;

	@EJB
	private PersonEAOLocal personEAO;

	public Facade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event addEvent(Event event) {
		return eventEAO.add(event);
	}

	@Override
	public Nation addNation(Nation nation) {
		return nationEAO.add(nation);
	}

	@Override
	public Person addPerson(Person person) {
		return personEAO.add(person);
	}

	@Override
	public void deleteEvent(long id) {
		eventEAO.delete(id);
	}

	@Override
	public void deleteNation(long id) {
		nationEAO.delete(id);
	}

	@Override
	public void deletePerson(long id) {
		personEAO.delete(id);
	}

	public List<Event> findAllEvents() {
		return eventEAO.findAll();
	}

	public List<Nation> findAllNations() {
		return nationEAO.findAll();
	}

	public List<Person> findAllPersons() {
		return personEAO.findAll();
	}

	@Override
	public Event findEventById(long id) {
		return eventEAO.findById(id);
	}

	@Override
	public Nation findNationById(long id) {
		return nationEAO.findById(id);
	}

	@Override
	public Person findPersonById(long id) {
		return personEAO.findById(id);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventEAO.update(event);
	}

	@Override
	public Nation updateNation(Nation nation) {
		return nationEAO.update(nation);
	}

	@Override
	public Person updatePerson(Person person) {
		return personEAO.update(person);
	}

}
