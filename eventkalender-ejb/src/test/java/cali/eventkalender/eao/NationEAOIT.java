package cali.eventkalender.eao;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cali.eventkalender.model.Nation;

@RunWith(JUnit4.class)
public class NationEAOIT {

	// protected static EntityManager em;
	// protected static EntityManagerFactory emf;
	//
	// @BeforeClass
	// public static void init() throws FileNotFoundException, SQLException {
	// emf = Persistence.createEntityManagerFactory("EventkalenderPU_Test");
	// em = emf.createEntityManager();
	// }

	private static Context ctx;
	private static EJBContainer ejbContainer;

	@BeforeClass
	public static void setUp() {
		ejbContainer = EJBContainer.createEJBContainer();
		System.out.println("Opening the container");
		ctx = ejbContainer.getContext();
	}
	
	@Test
	public void addNation() {
//		NationEAO nationEAO = (NationEAO) ctx.lookup("java:global/classes/CommentService");
//		nationEAO.add(new Nation("test"));
	}

	@AfterClass
	public static void tearDown() {
		//ejbContainer.close();
		System.out.println("Closing the container");
	}

	// @AfterClass
	// public static void tearDown() {
	// em.clear();
	// em.close();
	// emf.close();
	// }

}
