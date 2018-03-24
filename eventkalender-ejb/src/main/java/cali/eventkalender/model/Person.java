package cali.eventkalender.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@Table(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 3103101978093076417L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Column(name = "FirstName", nullable = false)
	private String firstName;

	@Column(name = "LastName", nullable = false)
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persons")
	private Set<Event> events;

	public Person() {
		this.events = new LinkedHashSet<>();
	}
	
	public Person(String firstName, String lastName) {
		this();
		setFirstName(Objects.requireNonNull(firstName));
		setLastName(Objects.requireNonNull(lastName));
	}
	
	public Person(String firstName, String lastName, Set<Event> events) {
		this(firstName, lastName);
		setEvents(Objects.requireNonNull(events));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = new LinkedHashSet<>();
		for (Event e : events) {
			addEvent(e);
		}
	}
	
	public void addEvent(Event event) {
		if (event != null) {
			if (!this.events.contains(event)) {
				this.events.add(event);
			}
			if (!event.getPersons().contains(this)) {
				event.getPersons().add(this);
			}
		}
//		if (event != null && !event.getPersons().contains(this)) {
//			this.events.add(event);
//			Set<Person> persons = event.getPersons();
//			if (!persons.contains(this)) {
//				event.addPerson(this);
//			}
//		}
	}
	
	public void deleteEvent(long id) {
		Optional<Event> e = this.events.stream().filter(x -> id == x.getId()).findFirst();
		if (e.isPresent()) {
			deleteEvent(e.get());
		}
	}
	
	public void deleteEvent(Event event) {
		if (event != null) {
			this.events.remove(event);
			event.getPersons().remove(this);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person) obj;
		return Objects.equals(this.id, p.id) && Objects.equals(this.firstName, p.firstName)
				&& Objects.equals(this.lastName, p.lastName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return Objects.hash(this.id * prime, this.firstName, this.lastName);
	}

}

