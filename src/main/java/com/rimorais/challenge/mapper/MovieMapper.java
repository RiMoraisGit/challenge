package com.rimorais.challenge.mapper;

import com.rimorais.challenge.dto.MovieDTO;
import com.rimorais.challenge.model.Movie;

public class MovieMapper {
	
	//Method to map entity to DTO
	public static MovieDTO mapToMovieDTO(Movie movie) {
		return new MovieDTO(
				movie.getId(),
				movie.getTitle(),
				movie.getDate(),
				movie.getRank(),
				movie.getRevenue()
		);
	}
	
	//Method to map DTO to entity
	public static Movie mapToMovie(MovieDTO movieDTO) {
		return new Movie(
				movieDTO.getId(),
				movieDTO.getTitle(),
				movieDTO.getDate(),
				movieDTO.getRank(),
				movieDTO.getRevenue()
		);
	}

}
