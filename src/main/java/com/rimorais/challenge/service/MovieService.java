package com.rimorais.challenge.service;

import java.util.List;

import com.rimorais.challenge.dto.MovieDTO;

public interface MovieService {
	
	MovieDTO createMovie(MovieDTO movieDTO);
	
	List<MovieDTO> getAllMovies();
	
	MovieDTO getMovieById(Long movieId);
	
	List<MovieDTO> getMoviesAfterDate(Integer date);
	
	MovieDTO updateMovie(Long movieId, MovieDTO updatedMovie);
	
	void deleteMovie(Long movieId);

}
