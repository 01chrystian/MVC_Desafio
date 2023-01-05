package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.Event;
import br.com.crud.web.myApp.services.EventService;

@Controller
@RequestMapping(value = "/Event")
public class EventController {

	@Autowired
	private EventService service;

	@GetMapping
	public ResponseEntity<List<Event>> findAll() {
		List<Event> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Event> findById(@PathVariable Long id) {
		Event obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
