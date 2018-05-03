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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Nation.findAll", query = "SELECT n FROM Nation n")
@Table(name = "Nation")
public class Nation implements Serializable {

	private static final long serialVersionUID = -8440701148404480824L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, mappedBy = "nation", orphanRemoval = true)
	private List<Event> events;

	public Nation() {
		this.id = Long.MIN_VALUE;
		this.events = new ArrayList<>();
	}

	public Nation(String name) {
		this();
		setName(Objects.requireNonNull(name));
	}

	public Nation(String name, List<Event> events) {
		this(name);
		setEvents(Objects.requireNonNull(events));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	// Denna metod följer inte Law of Demeter (än)
	public void addEvent(Event event) {
		if (event != null) {
			Nation n = event.getNation();
			if (n != null && n != this) {
				n.deleteEvent(event);
			}
			if (!hasEvent(event)) {
				this.events.add(event);
				if (event.getNation() != this) {
					event.setNation(this);
				}
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
			event.setNation(null);
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
		if (!(obj instanceof Nation)) {
			return false;
		}
		Nation n = (Nation) obj;
		return Objects.equals(this.id, n.id) && Objects.equals(this.name, n.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return Objects.hash(this.id * prime, this.name);
	}

}
