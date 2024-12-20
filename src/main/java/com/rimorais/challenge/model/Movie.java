package com.rimorais.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "date", nullable = false)
	private Integer date;
	
	@Column(name = "rank", nullable = false)
	private Float rank;
	
	@Column(name = "revenue", nullable = false)
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
	public Movie(Long id, String title, Integer date, Float rank, Long revenue) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.rank = rank;
		this.revenue = revenue;
	}

	//Constructor without attributes
	public Movie() {
		super();
	}

}
