package cali.eventkalender.eao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import cali.eventkalender.model.Nation;

@RunWith(Arquillian.class)
public class NationEAOIT {

	@EJB
	private NationEAOLocal nationEAO;
	
	@Deployment
	public static JavaArchive createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "nationeao-it.jar").addClasses(Nation.class, NationEAO.class)
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
	}

	@Test
	public void addNation() {
		Nation nation = new Nation("TESTNATION");

		nationEAO.add(nation);

		Nation fetchedNation = nationEAO.findById(nation.getId());

		assertNotNull(fetchedNation);
		assertEquals("TESTNATION", fetchedNation.getName());
	}

}
