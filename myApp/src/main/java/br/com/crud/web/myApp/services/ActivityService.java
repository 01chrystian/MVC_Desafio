package br.com.crud.web.myApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.web.myApp.entities.Activity;
import br.com.crud.web.myApp.repositories.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;

	public List<Activity> findAll() {
		return repository.findAll();
	}

	public Activity findById(Long id) {
		Optional<Activity> obj = repository.findById(id);
		return obj.get();
	}
}
