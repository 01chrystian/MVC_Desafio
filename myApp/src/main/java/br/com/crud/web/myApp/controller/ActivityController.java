package br.com.crud.web.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crud.web.myApp.entities.Activity;
import br.com.crud.web.myApp.services.ActivityService;

@Controller
@RequestMapping(value = "/Activity")
public class ActivityController {

	@Autowired
	private ActivityService service;

	@GetMapping
	public ResponseEntity<List<Activity>> findAll() {
		List<Activity> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Activity> findById(@PathVariable Long id) {
		Activity obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
