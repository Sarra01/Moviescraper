package classesTests;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import application.model.Actor;
import application.repository.ActorRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableAutoConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)


//@ContextConfiguration("classpath: /SpringModule/pom.xml")
//@ContextConfiguration(classes = Actor.class)

class ActorTest {

	@Autowired
	private ActorRepository repForTest;

	@AfterEach
	void tearDown() {
			repForTest.deleteAll();
	}
	
	
	
	@Test
	@Rollback(false)
	void testAddActor() {
		Actor actor = new Actor();
		actor.setNameActor("Cara DeLevigne");
		Actor actorToAdd = repForTest.save(actor);
		long actorId = actor.getIdActor();
		assertEquals(actorToAdd.getIdActor(), actorId);
	}

	@Test
	@Rollback(false)
	void testGetActor() {

		Optional<Actor> act = repForTest.findById(52L);
		Actor actor = act.get();
		long actorid = actor.getIdActor();
		System.out.println(actorid);
		assertEquals(52L, actorid);
	}

	@Test
	@Rollback(false)
	void testGetActors() {
		List<Actor> l = repForTest.findAll();
		assertThat(l.size()).isGreaterThan(1);
	}

	@Test
	@Rollback(false)
	void testDeleteActor() {
		Optional<Actor> act = repForTest.findById(502L);
		Actor actor = act.get();
		long actid = actor.getIdActor();
		repForTest.deleteById(actid);
	}
}
