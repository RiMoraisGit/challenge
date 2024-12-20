package com.rimorais.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rimorais.challenge.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	//Method that returns a list of movies released after a given date ordered by date in ascending order using SQL
	@Query(value = "SELECT * FROM Movie WHERE date > ?1 ORDER BY date ASC", nativeQuery = true)
	public List<Movie> getAfterDate(Integer date);

}
