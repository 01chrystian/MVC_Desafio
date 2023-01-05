package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.Participant;
import br.com.crud.web.myApp.services.ParticipantService;

@Controller
@RequestMapping(value = "/Participants")
public class ParticipantController {

	@Autowired
	private ParticipantService service;

	@GetMapping
	public String findAll(Model model) throws Exception {
		List<Participant> list = service.findAll();
		model.addAttribute("pessoas", list);
		return "participant";
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Participant> findById(@PathVariable Long id) {
		Participant obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/salvarpessoa", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })

	public String save(Participant participant) throws Exception {
		service.save(participant);
		return "cadastro/cadastropessoa";
	}

}
