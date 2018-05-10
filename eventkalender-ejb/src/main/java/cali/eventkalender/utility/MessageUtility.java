package cali.eventkalender.utility;

import java.util.Iterator;
import java.util.List;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Person;

public class MessageUtility {

	public static String getPersonsInvitationMessage(List<Person> persons, int outputCap) {
		StringBuilder builder = new StringBuilder();
		int personsOutputCap = outputCap;
		int personsSize = persons.size();
		if (personsSize == 0) {
			return "inga personer";
		} else if (personsSize <= personsOutputCap) {
			if (personsSize == 1) {
				Person onlyPerson = persons.get(0);
				builder.append("personen " + onlyPerson.getFirstName() + " " + onlyPerson.getLastName());
			} else {
				builder.append("personerna ");
				for (int i = 0; i < personsSize; i++) {
					Person p = persons.get(i);
					builder.append(p.getFirstName() + " " + p.getLastName());
					if (i != personsSize - 1) {
						if (i + 2 == personsSize) {
							builder.append(" och ");
						} else {
							builder.append(", ");
						}
					}
				}
			}
		} else {
			builder.append(personsSize + " personer");
		}
		return builder.toString();
	}
	
	public static String getEventsInvitationMessage(List<Event> events, int outputCap) {
		StringBuilder builder = new StringBuilder();
		int eventsOutputCap = outputCap;
		int eventsSize = events.size();
		if (eventsSize == 0) {
			return "inga evenemang";
		} else if (eventsSize <= eventsOutputCap) {
			if (eventsSize == 1) {
				Event onlyEvent = events.get(0);
				builder.append("evenemanget " + onlyEvent.getName());
			} else {
				builder.append("evenemangen ");
				for (int i = 0; i < eventsSize; i++) {
					Event e = events.get(i);
					builder.append(e.getName());
					if (i != eventsSize - 1) {
						if (i + 2 == eventsSize) {
							builder.append(" och ");
						} else {
							builder.append(", ");
						}
					}
				}
			}
		} else {
			builder.append(eventsSize + " evenemang");
		}
		return builder.toString();
	}
	
}
