package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	Film findByNameFilm(String name);

}