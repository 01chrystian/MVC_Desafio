package br.com.crud.web.myApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.web.myApp.entities.ReadParticipant;

@Repository
public interface ReadParticipantRepository extends JpaRepository<ReadParticipant, Long>{

}
