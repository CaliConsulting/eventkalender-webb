package cali.eventkalender.eao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;

import cali.eventkalender.model.Nation;
import cali.eventkalender.test.Deployments;
import cali.eventkalender.test.Deployments.ArchiveType;
import cali.eventkalender.test.PersistenceManagerLocal;

@RunWith(Arquillian.class)
public class NationEAOIT {
    
    private String expectedNationName;
    
    private Nation expectedNation;
    
    @EJB
    private NationEAOLocal nationEAO;
    
    @EJB
    private PersistenceManagerLocal persistenceManager;

    @Deployment
    public static Archive<?> createArchive() {
        return Deployments.getArchive(ArchiveType.EAO);
    }
    
    @Before
    public void setup() {
        expectedNationName = "TESTNATION";
        
        expectedNation = new Nation(expectedNationName);
    }
    
    @After
    public void teardown() {
        persistenceManager.cleanDatabase();
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
    public void deleteWhenNull() {
        long id = expectedNation.getId();
        nationEAO.delete(id);
        
        Nation fetchedNation = nationEAO.findById(id);
        
        assertNull(fetchedNation);
    }
    
    @Test
    public void findAll() {
        nationEAO.add(expectedNation);
        
        List<Nation> nations = nationEAO.findAll();
        
        assertEquals(1, nations.size());
        assertTrue(nations.contains(expectedNation));
    }
    
    @Test
    public void findById() {
        nationEAO.add(expectedNation);
        
        Nation fetchedNation = nationEAO.findById(expectedNation.getId());
        
        assertEquals(expectedNation, fetchedNation);
    }
    
    
    @Test
    public void update() {
        nationEAO.add(expectedNation);
        
        expectedNation.setName("UPDATENATION");
        nationEAO.update(expectedNation);
        
        assertEquals("UPDATENATION", expectedNation.getName());
    }

}
