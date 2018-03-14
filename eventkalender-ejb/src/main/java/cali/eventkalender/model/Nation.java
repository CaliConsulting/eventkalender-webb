package cali.eventkalender.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Nation")
public class Nation implements Serializable {

	private static final long serialVersionUID = -8440701148404480824L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	private long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "nation", fetch = FetchType.EAGER)
	private List<Event> events;

	public Nation() {
		this.events = new ArrayList<>();
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
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
		return Objects.hash(this.id, this.name);
	}

}
