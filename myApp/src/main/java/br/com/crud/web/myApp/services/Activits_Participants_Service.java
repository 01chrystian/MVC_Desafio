package br.com.crud.web.myApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.web.myApp.entities.Activits_Participants;
import br.com.crud.web.myApp.repositories.Activits_Participants_Repository;

@Service
public class Activits_Participants_Service {

	@Autowired
	private Activits_Participants_Repository repository;

	public List<Activits_Participants> findAll() {
		return repository.findAll();
	}

	public Activits_Participants findById(Long id) {
		Optional<Activits_Participants> obj = repository.findById(id);
		return obj.get();
	}
}
