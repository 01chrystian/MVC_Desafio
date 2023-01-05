package br.com.crud.web.myApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.web.myApp.entities.Group;
import br.com.crud.web.myApp.repositories.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;

	public List<Group> findAll() {
		return repository.findAll();
	}

	public Group findById(Long id) {
		Optional<Group> obj = repository.findById(id);
		return obj.get();
	}
}
