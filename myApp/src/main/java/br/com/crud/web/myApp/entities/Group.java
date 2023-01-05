package br.com.crud.web.myApp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_group")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer quantityParticipant;

	@OneToMany(mappedBy = "group")
	private List<Participant> participants = new ArrayList<>();

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "tb_activity_group", joinColumns = @JoinColumn(name = "activity_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<Activity> activits = new HashSet<>();

	public Group() {

	}

	public Group(Long id, String name, Integer quantityParticipant) {
		super();
		this.id = id;
		this.name = name;
		this.quantityParticipant = quantityParticipant;
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

	public Integer getQuantityParticipant() {
		return quantityParticipant;
	}

	public void setQuantityParticipant(Integer quantityParticipant) {
		this.quantityParticipant = quantityParticipant;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public Set<Activity> getActivits() {
		return activits;
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
		Group other = (Group) obj;
		return Objects.equals(id, other.id);
	}

}
