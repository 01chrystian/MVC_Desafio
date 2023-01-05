package br.com.crud.web.myApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.web.myApp.entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>{

}
