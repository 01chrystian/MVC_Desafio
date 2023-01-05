package br.com.crud.web.myApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.web.myApp.entities.ReadParticipant;
import br.com.crud.web.myApp.repositories.ReadParticipantRepository;

@Service
public class ReadParticipantService {

	@Autowired
	private ReadParticipantRepository repository;

	public List<ReadParticipant> findAll() {
		return repository.findAll();
	}

	public ReadParticipant findById(Long id) {
		Optional<ReadParticipant> obj = repository.findById(id);
		return obj.get();
	}
}
