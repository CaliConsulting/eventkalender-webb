package cali.eventkalender.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deployments {

    private static final Logger LOGGER = LoggerFactory.getLogger(Deployments.class);

    public enum ArchiveType {
        EAO,
        // MODEL
    }

    public static Archive<?> getArchive(ArchiveType type) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Deployment triggered!");
        } else {
            String output = String.format("[%s] Deployment triggered!", Deployments.class.getName());
            System.out.println(output);
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH-mm-ss-SSS");
        String fullName = String.format("eventkalender-aq-deployment-%s", now.format(formatter));

        switch (type) {
            case EAO:
                return getEntityAccessObjectsArchive(fullName);
            default:
                throw new IllegalArgumentException(type + "is not a valid option");
        }
    }

    private static Archive<?> getEntityAccessObjectsArchive(String name) {
        JavaArchive testingLibrary = ShrinkWrap.create(JavaArchive.class, name + "-eao.jar");
        testingLibrary.addPackages(true, "cali.eventkalender.eao", "cali.eventkalender.model");
        testingLibrary.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
        return testingLibrary;
    }

}
