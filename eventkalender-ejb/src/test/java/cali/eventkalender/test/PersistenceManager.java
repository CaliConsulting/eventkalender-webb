package cali.eventkalender.test;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import cali.eventkalender.eao.EventEAOLocal;
import cali.eventkalender.eao.NationEAOLocal;
import cali.eventkalender.eao.PersonEAOLocal;

@Stateless
public class PersistenceManager implements PersistenceManagerLocal {

	@EJB
	private EventEAOLocal eventEAO;

	@EJB
	private NationEAOLocal nationEAO;

	@EJB
	private PersonEAOLocal personEAO;

	public void cleanDatabase() {
		// Delete all events
		List<Long> eventIds = eventEAO.findAll().stream().map(x -> x.getId()).collect(Collectors.toList());
		for (Long eventId : eventIds) {
			eventEAO.delete(eventId);
		}

		// Delete all nations
		List<Long> nationIds = nationEAO.findAll().stream().map(x -> x.getId()).collect(Collectors.toList());
		for (Long nationId : nationIds) {
			nationEAO.delete(nationId);
		}

		// Delete all persons
		List<Long> personIds = personEAO.findAll().stream().map(x -> x.getId()).collect(Collectors.toList());
		for (Long personId : personIds) {
			eventEAO.delete(personId);
		}
	}

}
