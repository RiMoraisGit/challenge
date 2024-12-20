package com.rimorais.challenge.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rimorais.challenge.dto.MovieDTO;
import com.rimorais.challenge.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	//Inject Dependency
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	//Method to create a movie
	@PostMapping
	public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
		MovieDTO savedMovie = movieService.createMovie(movieDTO);
		
		return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
	}
	
	//Method to retrieve all movies
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAllMovies() {
		List<MovieDTO> movies = movieService.getAllMovies();
		
		return ResponseEntity.ok(movies);
	}
	
	//Method to retrieve a single movie with given id
	@GetMapping("{id}")
	public ResponseEntity<MovieDTO> getMovieById(@PathVariable("id") Long movieId) {
		MovieDTO movieDTO = movieService.getMovieById(movieId);
		
		return ResponseEntity.ok(movieDTO);
	}
	
	//Method to retrieve all movies released after a given date
	@GetMapping("/filter/{date}")
	public ResponseEntity<List<MovieDTO>> getMoviesAfterDate(@PathVariable("date") Integer date) {
		List<MovieDTO> movies = movieService.getMoviesAfterDate(date);
		
		return ResponseEntity.ok(movies);
	}
	
	//Method to update a single movie with given id
	@PutMapping("{id}")
	public ResponseEntity<MovieDTO> updateMovie(@PathVariable("id") Long movieId, @RequestBody MovieDTO updatedMovie) {
		MovieDTO movieDTO = movieService.updateMovie(movieId, updatedMovie);
		
		return ResponseEntity.ok(movieDTO);
	}
	
	//Method to delete a single movie with given id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
		movieService.deleteMovie(movieId);
		
		return ResponseEntity.ok("Movie deleted successfully!");
	}

}
