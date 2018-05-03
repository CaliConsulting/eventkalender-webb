package cali.eventkalender.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Person;

@Stateless
public class PersonEAO implements PersonEAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    public PersonEAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Person add(Person person) {
		em.persist(person);
		
		for (Event event : person.getEvents()) {
		    if (event.getId() == Long.MIN_VALUE) {
	            em.persist(event);
		    }
		}
		
		return person;
	}

	@Override
	public void delete(long id) {
		Person p = findById(id);
		if (p != null) {
			em.remove(p);
		}
	}

	@Override
	public List<Person> findAll() {
		TypedQuery<Person> tq = em.createNamedQuery("Person.findAll", Person.class);
		return tq.getResultList();
	}

	@Override
	public Person findById(long id) {
		return em.find(Person.class, id);
	}

	@Override
	public Person update(Person person) {
		em.merge(person);
		return person;
	}

}
