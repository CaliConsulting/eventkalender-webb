package cali.eventkalender.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cali.eventkalender.model.Nation;

@Stateless
public class NationEAO implements NationEAOLocal {

	@PersistenceContext
	private EntityManager em;

	public NationEAO() {
		// TODO Auto-generated constructor stub
	}

	public Nation add(Nation nation) {
		em.persist(nation);
		return nation;
	}
	
	public void delete(long id) {
		Nation n = findById(id);
		if (n != null) {
			em.remove(n);
		}
	}
	
	public Nation findById(long id) {
		return em.find(Nation.class, id);
	}

	public Nation update(Nation nation) {
		em.merge(nation);
		return nation;
	}

}

