package com.rimorais.challenge.validator;

import com.rimorais.challenge.dto.MovieDTO;
import com.rimorais.challenge.exception.OutOfRangeException;

public class MovieValidator {
	
	//Method to validate "rank" field
	public static void checkOutOfRange(MovieDTO movieDTO) {
		
		if(movieDTO.getRank() < 0 || movieDTO.getRank() > 10)
			throw new OutOfRangeException("Rank must be between 0-10 please!");
	}
	
	//Method to validate "date" and "revenue" fields
	public static void checkNegatives(MovieDTO movieDTO) {
		
		if(movieDTO.getDate() < 0 || movieDTO.getRevenue() < 0)
			throw new OutOfRangeException("No negative values alowed please!");
	}
}
