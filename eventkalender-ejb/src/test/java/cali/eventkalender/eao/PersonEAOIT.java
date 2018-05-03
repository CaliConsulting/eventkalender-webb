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
import cali.eventkalender.model.Person;
import cali.eventkalender.test.Deployments;
import cali.eventkalender.test.Deployments.ArchiveType;
import cali.eventkalender.test.PersistenceManagerLocal;

@RunWith(Arquillian.class)
public class PersonEAOIT {
    
    private String expectedPersonFirstName;
    private String expectedPersonLastName;
    
    private Person expectedPerson;
    
    @EJB
    private PersonEAOLocal personEAO;
    
    @EJB
    private PersistenceManagerLocal persistenceManager;

    @Deployment
    public static Archive<?> createArchive() {
        return Deployments.getArchive(ArchiveType.EAO);
    }
    
    @Before
    public void setup() {
        expectedPersonFirstName = "TESTFIRSTNAME";
        expectedPersonLastName = "TESTLASTNAME";
        
        expectedPerson = new Person(expectedPersonFirstName, expectedPersonLastName);
    }
    
    @After
    public void teardown() {
        persistenceManager.cleanDatabase();
    }

    @Test
    public void add() {
        personEAO.add(expectedPerson);

        Person fetchedPerson = personEAO.findById(expectedPerson.getId());

        assertNotNull(fetchedPerson);
        assertEquals(expectedPersonFirstName, fetchedPerson.getFirstName());
        assertEquals(expectedPersonLastName, fetchedPerson.getLastName());
    }
    
    @Test
    public void delete() {
        personEAO.add(expectedPerson);
        
        long id = expectedPerson.getId();
        personEAO.delete(id);
        
        Person fetchedPerson = personEAO.findById(id);
        
        assertNull(fetchedPerson);
    }
    
    @Test
    public void findAll() {
        personEAO.add(expectedPerson);
        
        List<Person> persons = personEAO.findAll();
        
        assertEquals(1, persons.size());
        assertTrue(persons.contains(expectedPerson));
    }
    
    @Test
    public void findById() {
        personEAO.add(expectedPerson);
        
        Person fetchedPerson = personEAO.findById(expectedPerson.getId());
        
        assertEquals(expectedPerson, fetchedPerson);
    }
    
    @Test
    public void update() {
        personEAO.add(expectedPerson);
        
        expectedPerson.setFirstName("UPDATEFIRSTNAME");
        expectedPerson.setLastName("UPDATELASTNAME");
        personEAO.update(expectedPerson);
        
        assertEquals("UPDATEFIRSTNAME", expectedPerson.getFirstName());
        assertEquals("UPDATELASTNAME", expectedPerson.getLastName());
    }

}
