package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.Group;
import br.com.crud.web.myApp.services.GroupService;

@Controller
@RequestMapping(value = "/Group")
public class GroupController {

	@Autowired
	private GroupService service;

	@GetMapping
	public ResponseEntity<List<Group>> findAll() {
		List<Group> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Group> findById(@PathVariable Long id) {
		Group obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
