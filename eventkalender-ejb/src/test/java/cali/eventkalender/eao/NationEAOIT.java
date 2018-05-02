package cali.eventkalender.eao;

import org.junit.Before;
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
    
    private String expectedNationName;
    
    private Nation expectedNation;
    
    @EJB
    private NationEAOLocal nationEAO;

    @Deployment
    public static Archive<?> createArchive() {
        return Deployments.getArchive(ArchiveType.EAO);
    }
    
    @Before
    public void setup() {
        expectedNationName = "TESTNATION";
        
        expectedNation = new Nation(expectedNationName);
    }

    @Test
    public void add() {
        nationEAO.add(expectedNation);

        Nation fetchedNation = nationEAO.findById(expectedNation.getId());

        assertNotNull(fetchedNation);
        assertEquals(expectedNationName, fetchedNation.getName());
    }
    
    @Test
    public void delete() {
        nationEAO.add(expectedNation);
        
        long id = expectedNation.getId();
        nationEAO.delete(id);
        
        Nation fetchedNation = nationEAO.findById(id);
        
        assertNull(fetchedNation);
    }
    
    @Test
    public void update() {
        nationEAO.add(expectedNation);
        
        expectedNation.setName("UPDATENATION");
        nationEAO.update(expectedNation);
        
        assertEquals("UPDATENATION", expectedNation.getName());
    }

}
