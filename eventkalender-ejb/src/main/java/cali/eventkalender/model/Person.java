package cali.eventkalender.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

	@Column(name = "FirstName", length = 255, nullable = false)
	private String firstName;

	@Column(name = "LastName", length = 255, nullable = false)
	private String lastName;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.EAGER, mappedBy = "persons")
	private List<Event> events;

	public Person() {
		this.id = Long.MIN_VALUE;
		this.events = new ArrayList<>();
	}

	public Person(String firstName, String lastName) {
		this();
		setFirstName(Objects.requireNonNull(firstName));
		setLastName(Objects.requireNonNull(lastName));
	}

	public Person(String firstName, String lastName, List<Event> events) {
		this(firstName, lastName);
		setEvents(Objects.requireNonNull(events));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = new ArrayList<>();
		for (Event e : events) {
			addEvent(e);
		}
	}

	public void addEvent(Event event) {
		if (event != null) {
			if (!hasEvent(event)) {
				this.events.add(event);
			}
			if (!event.hasPerson(this)) {
				event.addPerson(this);
			}
		}
	}

	public void deleteEvent(long id) {
		Optional<Event> e = this.events.stream().filter(x -> x.getId() == id).findFirst();
		if (e.isPresent()) {
			deleteEvent(e.get());
		}
	}

	public void deleteEvent(Event event) {
		if (event != null) {
			this.events.remove(event);
			if (event.hasPerson(this)) {
				event.deletePerson(this);
			}
		}
	}

	public boolean hasEvent(Event event) {
		return this.events.contains(event);
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
