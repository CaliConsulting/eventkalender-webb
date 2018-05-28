package cali.eventkalender.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
@Table(name = "Event")
public class Event implements Serializable {

	private static final long serialVersionUID = 4865562529984171768L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Column(name = "Name", length = 255, nullable = false)
	private String name;

	@Column(name = "Summary", length = 4095, nullable = false)
	private String summary;

	@Column(name = "StartTime", nullable = false)
	private LocalDateTime startTime;

	@Column(name = "EndTime", nullable = false)
	private LocalDateTime endTime;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "NationId", referencedColumnName = "Id", nullable = false)
	private Nation nation;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "PersonEvent", joinColumns = @JoinColumn(name = "EventId", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "PersonId", referencedColumnName = "Id"))
	private List<Person> persons;

	public Event() {
		this.id = Long.MIN_VALUE;
		this.persons = new ArrayList<>();
	}

	public Event(String name, String summary, LocalDateTime startTime, LocalDateTime endTime) {
		this();
		setName(Objects.requireNonNull(name));
		setSummary(Objects.requireNonNull(summary));
		setStartTime(Objects.requireNonNull(startTime));
		setEndTime(Objects.requireNonNull(endTime));
	}

	public Event(String name, String summary, LocalDateTime startTime, LocalDateTime endTime, Nation nation,
			List<Person> persons) {
		this(name, summary, startTime, endTime);
		setNation(Objects.requireNonNull(nation));
		setPersons(Objects.requireNonNull(persons));
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getStartTimeFormatted() {
		LocalDateTime start = getStartTime();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return format.format(start);
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public String getEndTimeFormatted() {
		LocalDateTime end = getEndTime();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return format.format(end);
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		if (nation != this.nation) {
			this.nation = nation;
		}
		if (nation != null && !nation.hasEvent(this)) {
			nation.addEvent(this);
		}
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = new ArrayList<>();
		for (Person p : persons) {
			addPerson(p);
		}
	}

	public void addPerson(Person person) {
		if (person != null) {
			if (!hasPerson(person)) {
				this.persons.add(person);
			}
			if (!person.hasEvent(this)) {
				person.addEvent(this);
			}
		}
	}

	public void deletePerson(long id) {
		Optional<Person> p = this.persons.stream().filter(x -> x.getId() == id).findFirst();
		if (p.isPresent()) {
			deletePerson(p.get());
		}
	}

	public void deletePerson(Person person) {
		if (person != null) {
			this.persons.remove(person);
			if (person.hasEvent(this)) {
				person.deleteEvent(this);
			}
		}
	}

	public boolean hasPerson(Person person) {
		return this.persons.contains(person);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Event)) {
			return false;
		}
		Event e = (Event) obj;
		return Objects.equals(this.id, e.id) && Objects.equals(this.name, e.name)
				&& Objects.equals(this.summary, e.summary) && Objects.equals(this.startTime, e.startTime)
				&& Objects.equals(this.endTime, e.endTime);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return Objects.hash(this.id * prime, this.name, this.startTime, this.endTime);
	}

}
