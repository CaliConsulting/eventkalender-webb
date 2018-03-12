package cali.eventkalender.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import cali.eventkalender.eao.NationEAOLocal;
import cali.eventkalender.model.Nation;

@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private NationEAOLocal nationEAO;
	
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    
    public Nation findByNationId(long id) {
    	return nationEAO.findById(id);
    }

}
