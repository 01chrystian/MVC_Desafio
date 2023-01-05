package br.com.crud.web.myApp.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.crud.web.myApp.entities.Activits_Participants;
import br.com.crud.web.myApp.entities.Activity;
import br.com.crud.web.myApp.entities.Event;
import br.com.crud.web.myApp.entities.Group;
import br.com.crud.web.myApp.entities.Participant;
import br.com.crud.web.myApp.entities.ReadParticipant;
import br.com.crud.web.myApp.entities.User;
import br.com.crud.web.myApp.repositories.Activits_Participants_Repository;
import br.com.crud.web.myApp.repositories.ActivityRepository;
import br.com.crud.web.myApp.repositories.EventRepository;
import br.com.crud.web.myApp.repositories.GroupRepository;
import br.com.crud.web.myApp.repositories.ParticipantRepository;
import br.com.crud.web.myApp.repositories.ReadParticipantRepository;
import br.com.crud.web.myApp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ParticipantRepository participantRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private Activits_Participants_Repository activitsParticipantsrepository;

	@Autowired
	private ReadParticipantRepository readparticipantrepository;

	@Override
	public void run(String... args) throws Exception {

		User us = new User("Chrystian", "teste@gmail.com", "abcd", 3213);

		userRepository.saveAll(Arrays.asList(us));

		Event ev1 = new Event(null, "Evento (1)", LocalDate.parse("2022-06-28"), LocalDate.parse("2022-08-31"));
		Event ev2 = new Event(null, "Evento (2)", LocalDate.parse("2022-09-15"), LocalDate.parse("2022-10-31"));

		eventRepository.saveAll(Arrays.asList(ev1, ev2));

		Activity act1 = new Activity(null, "Corrida", LocalDate.parse("2022-07-23"), LocalDate.parse("2022-07-30"),
				ev1);
		Activity act2 = new Activity(null, "Golfe", LocalDate.parse("2022-07-23"), LocalDate.parse("2022-07-30"), ev2);

		activityRepository.saveAll(Arrays.asList(act1, act2));

		Group group1 = new Group(null, "Alpha", 4);
		Group group2 = new Group(null, "Beta", 4);

		groupRepository.saveAll(Arrays.asList(group1, group2));

		group1.getActivits().add(act1);
		group1.getActivits().add(act2);
		group2.getActivits().add(act1);

		groupRepository.saveAll(Arrays.asList(group1, group2));

		// group 1
		Participant part1 = new Participant(null, "part1", "part1@gmail.com", "abcd", group1);
		Participant part2 = new Participant(null, "part2", "part2@gmail.com", "agdr", group1);
		Participant part3 = new Participant(null, "part3", "part3@gmail.com", "fsdd", group1);
		Participant part4 = new Participant(null, "part4", "part4@gmail.com", "khuf", group1);

		// group 2
		Participant part5 = new Participant(null, "part5", "part5@gmail.com", "dwad", group2);
		Participant part6 = new Participant(null, "part6", "part6@gmail.com", "fsdf", group2);
		Participant part7 = new Participant(null, "part7", "part7@gmail.com", "ghre", group2);
		Participant part8 = new Participant(null, "part8", "part8@gmail.com", "çoif", group2);

		participantRepository.saveAll(Arrays.asList(part1, part2, part3, part4, part5, part6, part7, part8));

		// chamando participant ao evento 1
		ev1.getParticipant().add(part1);
		ev1.getParticipant().add(part2);
		ev1.getParticipant().add(part2);
		ev1.getParticipant().add(part3);
		ev1.getParticipant().add(part4);

		// chamando participant ao evento 2
		ev2.getParticipant().add(part5);
		ev2.getParticipant().add(part6);
		ev2.getParticipant().add(part7);
		ev2.getParticipant().add(part8);
		eventRepository.saveAll(Arrays.asList(ev1, ev2));

		// add participant ao event 1
		part1.getEvents().add(ev1);
		part2.getEvents().add(ev1);
		part3.getEvents().add(ev1);
		part4.getEvents().add(ev1);
		part5.getEvents().add(ev1);

		// add participant ao event 2
		part6.getEvents().add(ev2);
		part7.getEvents().add(ev2);
		part8.getEvents().add(ev2);
		participantRepository.saveAll(Arrays.asList(part1, part2, part3, part4, part5, part6, part7, part8));

		Activits_Participants ap1 = new Activits_Participants(null, ev1.getName(), act1.getName(), group1.getName());
		Activits_Participants ap2 = new Activits_Participants(null, ev2.getName(), act2.getName(), group2.getName());
		activitsParticipantsrepository.saveAll(Arrays.asList(ap1, ap2));

		ReadParticipant rp1 = new ReadParticipant(null, part1.getName(), "Fez", "P", LocalDate.parse("2022-07-25"),
				ap1);
		ReadParticipant rp2 = new ReadParticipant(null, part2.getName(), "Não fez", "F", null, ap1);
		ReadParticipant rp3 = new ReadParticipant(null, part3.getName(), "Fez", "P", LocalDate.parse("2022-08-24"),
				ap2);
		ReadParticipant rp4 = new ReadParticipant(null, part3.getName(), "Não fez", "P", LocalDate.parse("2022-08-24"),
				ap2);
		readparticipantrepository.saveAll(Arrays.asList(rp1, rp2, rp3, rp4));

		// Activits_Participants ap1 = new Activits_Participants(null, ev1.getName(),
		// act1.getName(), part1.getName(),
		// LocalDate.parse("2022-07-24"), "Fez", "P", group1.getName());
		// Activits_Participants ap2 = new Activits_Participants(null, ev1.getName(),
		// act1.getName(), part2.getName(),
		// null, "Não fez", "F", group1.getName());
		// Activits_Participants ap3 = new Activits_Participants(null, ev1.getName(),
		// act1.getName(), part3.getName(),
		// LocalDate.parse("2022-07-26"), "Fez", "P", group1.getName());
		// Activits_Participants ap4 = new Activits_Participants(null, ev1.getName(),
		// act1.getName(), part4.getName(),
		// LocalDate.parse("2022-07-26"), "Não fez", "P", group1.getName());

		// Activits_Participants ap5 = new Activits_Participants(null, ev2.getName(),
		// act2.getName(), part5.getName(),
		// LocalDate.parse("2022-08-24"), "Fez", "P", group2.getName());
		// Activits_Participants ap6 = new Activits_Participants(null, ev2.getName(),
		// act2.getName(), part6.getName(),
		// LocalDate.parse("2022-08-24"), "Não fez", "P", group2.getName());
		// Activits_Participants ap7 = new Activits_Participants(null, ev2.getName(),
		// act2.getName(), part7.getName(),
		// LocalDate.parse("2022-07-29"), "Fez", "P", group2.getName());
		// Activits_Participants ap8 = new Activits_Participants(null, ev2.getName(),
		// act2.getName(), part8.getName(),
		// null, "Não fez", "F", group2.getName());

	}

}
