package cali.eventkalender.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	private long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Summary", nullable = false)
	private String summary;

	@Column(name = "StartTime", nullable = false)
	private LocalDateTime startTime;

	@Column(name = "EndTime", nullable = false)
	private LocalDateTime endTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NationId", referencedColumnName = "Id", nullable = false)
	private Nation nation;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PersonEvent", joinColumns = @JoinColumn(name = "EventId", referencedColumnName = "Id"),
			inverseJoinColumns = @JoinColumn(name = "PersonId", referencedColumnName = "Id"))
	private Set<Person> persons;

	public Event() {
		this.persons = new LinkedHashSet<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	public void addPerson(Person person) {
		this.persons.add(person);
		if (!person.getEvents().contains(this)) {
			person.getEvents().add(this);
		}
	}
	
	public void deletePerson(long id) {
		Optional<Person> p = this.persons.stream().filter(x -> id == x.getId()).findFirst();
		if (p.isPresent()) {
			deletePerson(p.get());
		}
	}
	
	public void deletePerson(Person person) {
		this.persons.remove(person);
		if (person.getEvents().contains(this)) {
			person.getEvents().remove(this);
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
		if (!(obj instanceof Event)) {
			return false;
		}
		Event e = (Event) obj;
		return Objects.equals(this.id, e.id) && Objects.equals(this.name, e.name)
				&& Objects.equals(this.startTime, e.endTime) && Objects.equals(this.endTime, e.endTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.startTime, this.endTime);
	}

}
