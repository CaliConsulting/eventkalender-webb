package cali.eventkalender.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;

@Stateless
public class NationEAO implements NationEAOLocal {

	@PersistenceContext
	private EntityManager em;

	public NationEAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Nation add(Nation nation) {
		for (Event event : nation.getEvents()) {
		    if (event.getId() < 0) {
		        em.persist(event);
		    }
		}
		em.persist(nation);
		return nation;
	}

	@Override
	public void delete(long id) {
		Nation n = findById(id);
		if (n != null) {
			em.remove(n);
		}
	}

	@Override
	public List<Nation> findAll() {
		TypedQuery<Nation> tq = em.createNamedQuery("Nation.findAll", Nation.class);
		return tq.getResultList();
	}

	@Override
	public Nation findById(long id) {
		return em.find(Nation.class, id);
	}

	@Override
	public Nation update(Nation nation) {
		em.merge(nation);
		return nation;
	}

}

