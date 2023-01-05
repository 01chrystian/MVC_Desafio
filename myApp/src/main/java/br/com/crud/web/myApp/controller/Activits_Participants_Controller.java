package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.Activits_Participants;
import br.com.crud.web.myApp.services.Activits_Participants_Service;

@Controller
@RequestMapping(value = "/Activits_Participants")
public class Activits_Participants_Controller {

	@Autowired
	private Activits_Participants_Service service;

	@GetMapping
	public ResponseEntity<List<Activits_Participants>> findAll() {
		List<Activits_Participants> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Activits_Participants> findById(@PathVariable Long id) {
		Activits_Participants obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
