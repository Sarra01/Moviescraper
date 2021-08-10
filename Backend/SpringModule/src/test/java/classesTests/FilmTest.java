package classesTests;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import application.model.Film;
import application.repository.FilmRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class FilmTest {

	@Autowired
	private FilmRepository repForTest;

	@Test
	@Rollback(false)
	void testAddFilm() {
		Film film = new Film();
		film.getIdFilm();
		Film filmToAdd = repForTest.save(film);
		long filmId = film.getIdFilm();
		assertEquals(filmToAdd.getIdFilm(), filmId);
	}

	@Test
	@Rollback(false)
	void testGetFilm() {

		Optional<Film> filmrep = repForTest.findById(1L);
		Film film = filmrep.get();
		long filmId = film.getIdFilm();
		System.out.println(filmId);
		assertEquals(1L, filmId);
	}

	@Test
	@Rollback(false)
	void testGetFilms() {
		List<Film> list = repForTest.findAll();
		assertThat(list.size()).isGreaterThan(1);
	}

	@Test
	@Rollback(false)
	void testDeleteFilm() {
		Optional<Film> filmToTest = repForTest.findById(502L);
		Film film = filmToTest.get();
		long filmId = film.getIdFilm();
		repForTest.deleteById(filmId);
	}
}