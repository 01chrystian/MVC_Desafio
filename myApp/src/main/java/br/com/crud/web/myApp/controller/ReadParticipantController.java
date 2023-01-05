package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.ReadParticipant;
import br.com.crud.web.myApp.services.ReadParticipantService;

@Controller
@RequestMapping(value = "/ReadParticipant")
public class ReadParticipantController {

	@Autowired
	private ReadParticipantService service;

	@GetMapping
	public ResponseEntity<List<ReadParticipant>> findAll() {
		List<ReadParticipant> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ReadParticipant> findById(@PathVariable Long id) {
		ReadParticipant obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
