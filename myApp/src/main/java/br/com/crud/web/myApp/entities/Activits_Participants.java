package br.com.crud.web.myApp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Activits_Participants")
public class Activits_Participants implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String event_name;
	private String activity_name;
	private String group_name;
		
	@OneToMany(mappedBy = "acpa")
	private List<ReadParticipant> acpas = new ArrayList<>();
	
	public Activits_Participants() {
		
	}
	
	public Activits_Participants(Long id, String event_name, String activity_name, String group_name) {
		super();
		this.id = id;
		this.event_name = event_name;
		this.activity_name = activity_name;
		this.group_name = group_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
	public List<ReadParticipant> getAcpas() {
		return acpas;
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
		Activits_Participants other = (Activits_Participants) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
