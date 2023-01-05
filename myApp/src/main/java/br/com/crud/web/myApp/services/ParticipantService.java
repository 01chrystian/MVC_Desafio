package br.com.crud.web.myApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.web.myApp.entities.Participant;
import br.com.crud.web.myApp.repositories.ParticipantRepository;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository repository;

	public List<Participant> findAll() {
		return repository.findAll();
	}

	public Participant findById(Long i) {
		Optional<Participant> obj = repository.findById(i);
		return obj.get();
	}

	public String save(Participant participant) {
		Participant obj = repository.save(participant);
		return obj.getName();
	}
}
