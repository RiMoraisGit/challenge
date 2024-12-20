package com.rimorais.challenge.dto;

public class MovieDTO {
	
	//Attributes
	private Long id;
	private String title;
	private Integer date;
	private Float rank;
	private Long revenue;
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getDate() {
		return date;
	}
	
	public void setDate(Integer date) {
		this.date = date;
	}
	
	public Float getRank() {
		return rank;
	}
	
	public void setRank(Float rank) {
		this.rank = rank;
	}
	
	public Long getRevenue() {
		return revenue;
	}
	
	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	//Constructor with all attributes
	public MovieDTO(Long id, String title, Integer date, Float rank, Long revenue) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.rank = rank;
		this.revenue = revenue;
	}

	//Constructor without attributes
	public MovieDTO() {
		super();
	}

}
