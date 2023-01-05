package br.com.crud.web.myApp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ReadParticipant")
public class ReadParticipant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String participant_name;
	private String status_activity;
	private String presence;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date_presence;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "participant_id")
	private Activits_Participants acpa;

	public ReadParticipant() {

	}

	public ReadParticipant(Long id, String participant_name, String status_activity, String presence,
			LocalDate date_presence, Activits_Participants acpa) {
		super();
		this.id = id;
		this.participant_name = participant_name;
		this.status_activity = status_activity;
		this.presence = presence;
		this.date_presence = date_presence;
		this.acpa = acpa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParticipant_name() {
		return participant_name;
	}

	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}

	public String getStatus_activity() {
		return status_activity;
	}

	public void setStatus_activity(String status_activity) {
		this.status_activity = status_activity;
	}

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public LocalDate getDate_presence() {
		return date_presence;
	}

	public void setDate_presence(LocalDate date_presence) {
		this.date_presence = date_presence;
	}

	public Activits_Participants getAcpa() {
		return acpa;
	}

	public void setAcpa(Activits_Participants acpa) {
		this.acpa = acpa;
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
		ReadParticipant other = (ReadParticipant) obj;
		return Objects.equals(id, other.id);
	}

}
