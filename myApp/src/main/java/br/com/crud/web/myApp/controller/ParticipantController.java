package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.Participant;
import br.com.crud.web.myApp.services.ParticipantService;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "/Participants")
public class ParticipantController {

	@Autowired
	private ParticipantService service;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Participant>> findAll(Model model) throws Exception {
		List<Participant> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Participant> findById(@PathVariable Long id) {
		Participant obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@PostMapping(value = "/salvarpessoa", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> save(Participant participant) throws Exception {
		String returnObj = service.save(participant);
		return ResponseEntity.ok().body(returnObj);
	}

	@CrossOrigin
	@PostMapping(value = "/remove/participant", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> remove(String email) throws Exception {
		String returnObj = service.remove(email);
		return ResponseEntity.ok().body(returnObj);
	}
}
