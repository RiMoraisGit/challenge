package com.rimorais.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rimorais.challenge.dto.MovieDTO;
import com.rimorais.challenge.exception.ResourceNotFoundException;
import com.rimorais.challenge.mapper.MovieMapper;
import com.rimorais.challenge.model.Movie;
import com.rimorais.challenge.repository.MovieRepository;
import com.rimorais.challenge.validator.MovieValidator;

@Service
public class MovieServiceImpl implements MovieService {
	
	//Inject Dependency
	private MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	//Method with logic to create a movie
	@Override
	public MovieDTO createMovie(MovieDTO movieDTO) {
		MovieValidator.checkOutOfRange(movieDTO);
		MovieValidator.checkNegatives(movieDTO);
		
		Movie movie = MovieMapper.mapToMovie(movieDTO);
		Movie savedMovie = movieRepository.save(movie);
		
		return MovieMapper.mapToMovieDTO(savedMovie);
		
	}
	
	//Method with logic to retrieve all movies
	@Override
	public List<MovieDTO> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		
		return movies.stream().map((movie) -> MovieMapper.mapToMovieDTO(movie)).collect(Collectors.toList());
	}

	//Method with logic to retrieve a single movie with given id
	@Override
	public MovieDTO getMovieById(Long movieId) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie with id " + movieId + "does not exist!"));
		
		return MovieMapper.mapToMovieDTO(movie);
	}
	
	//Method with logic to retrieve all movies released after a given date
	@Override
	public List<MovieDTO> getMoviesAfterDate(Integer date) {
		List<Movie> movies = movieRepository.getAfterDate(date);
		
		return movies.stream().map((movie) -> MovieMapper.mapToMovieDTO(movie)).collect(Collectors.toList());
	}
	
	//Method with logic to update a single movie with given id
	@Override
	public MovieDTO updateMovie(Long movieId, MovieDTO updatedMovie) {
		MovieValidator.checkOutOfRange(updatedMovie);
		MovieValidator.checkNegatives(updatedMovie);
		
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie with id " + movieId + "does not exist!"));
		
		movie.setTitle(updatedMovie.getTitle());
		movie.setDate(updatedMovie.getDate());
		movie.setRank(updatedMovie.getRank());
		movie.setRevenue(updatedMovie.getRevenue());
		
		Movie updatedMovieObj = movieRepository.save(movie);
		
		return MovieMapper.mapToMovieDTO(updatedMovieObj);
		
	}

	//Method with logic to delete a single movie with given id
	@Override
	public void deleteMovie(Long movieId) {
		movieRepository.findById(movieId)
		.orElseThrow(() -> new ResourceNotFoundException("Movie with id " + movieId + " does not exist"));
		
		movieRepository.deleteById(movieId);
	}

}
