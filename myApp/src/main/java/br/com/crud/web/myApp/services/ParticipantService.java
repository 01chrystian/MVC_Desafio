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
		repository.save(participant);
		return "Participante salvo!";
	}

	public String remove(String email) {
		List<Participant> obj = repository.findAll();
		for (Participant p : obj) {
			if (p.getEmail().equals(email)) {
				repository.delete(p);
			}
		}
		return "Participante removido!";
	}

}
