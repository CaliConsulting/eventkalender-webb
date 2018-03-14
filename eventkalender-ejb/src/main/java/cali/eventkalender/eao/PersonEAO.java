package cali.eventkalender.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Person findById(long id) {
		return em.find(Person.class, id);
	}

	@Override
	public Person update(Person person) {
		em.merge(person);
		return person;
	}

}
