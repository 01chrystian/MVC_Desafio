package br.com.crud.web.myApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.web.myApp.entities.Activits_Participants;

@Repository
public interface Activits_Participants_Repository extends JpaRepository<Activits_Participants, Long> {

}
