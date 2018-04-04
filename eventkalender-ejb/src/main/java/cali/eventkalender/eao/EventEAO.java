package cali.eventkalender.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cali.eventkalender.model.Event;

@Stateless
public class EventEAO implements EventEAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    public EventEAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Event add(Event event) {
		em.persist(event);
		return event;
	}

	@Override
	public void delete(long id) {
		Event e = findById(id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public List<Event> findAll() {
		TypedQuery<Event> tq = em.createNamedQuery("Event.findAll", Event.class);
		return tq.getResultList();
	}

	@Override
	public Event findById(long id) {
		return em.find(Event.class, id);
	}

	@Override
	public Event update(Event event) {
		em.merge(event);
		return event;
	}

}
