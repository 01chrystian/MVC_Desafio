package br.com.crud.web.myApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.web.myApp.entities.Event;
import br.com.crud.web.myApp.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	public List<Event> findAll() {
		return repository.findAll();
	}

	public Event findById(Long id) {
		Optional<Event> obj = repository.findById(id);
		return obj.get();
	}
}
