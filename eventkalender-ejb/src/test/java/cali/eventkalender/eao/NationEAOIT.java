package cali.eventkalender.eao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;

import cali.eventkalender.model.Nation;
import cali.eventkalender.test.Deployments;
import cali.eventkalender.test.Deployments.ArchiveType;

@RunWith(Arquillian.class)
public class NationEAOIT {

    @EJB
    private NationEAOLocal nationEAO;

    @Deployment
    public static Archive<?> createArchive() {
        return Deployments.getArchive(ArchiveType.EAO);
    }

    @Test
    public void add() {
        Nation nation = new Nation("TESTNATION");
        nationEAO.add(nation);

        Nation fetchedNation = nationEAO.findById(nation.getId());

        assertNotNull(fetchedNation);
        assertEquals("TESTNATION", fetchedNation.getName());
    }
    
    @Test
    public void delete() {
        Nation nation = new Nation("TESTNATION");
        nationEAO.add(nation);
        
        long id = nation.getId();
        nationEAO.delete(id);
        
        Nation fetchedNation = nationEAO.findById(id);
        
        assertNull(fetchedNation);
    }
    
    @Test
    public void update() {
        Nation nation = new Nation("TESTNATION");
        nationEAO.add(nation);
        
        nation.setName("UPDATENATION");
        nationEAO.update(nation);
        
        assertEquals("UPDATENATION", nation.getName());
    }

}
