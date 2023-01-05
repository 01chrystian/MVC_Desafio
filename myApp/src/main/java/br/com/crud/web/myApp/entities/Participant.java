package br.com.crud.web.myApp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_participant")
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String four_letters;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "tb_event_participant", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "participant_id"))
	private Set<Event> events = new HashSet<>();

	public Participant() {

	}

	public Participant(Long id, String name, String email, String four_letters, Group group) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.four_letters = four_letters;
		this.group = group;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFour_letters() {
		return four_letters;
	}

	public void setFour_letters(String four_letters) {
		this.four_letters = four_letters;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Set<Event> getEvents() {
		return events;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return Objects.equals(id, other.id);
	}
	

}
