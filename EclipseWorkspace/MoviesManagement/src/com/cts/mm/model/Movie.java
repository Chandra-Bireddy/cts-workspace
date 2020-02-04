package com.cts.mm.model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Movie implements Comparable<Movie>, Serializable{
	private String movieId;
	private String title;
	private double boxOffice;
	private LocalDate releaseDate;
	
	public Movie() {
		super();
	}
	
	public Movie(String movieId, String title, double boxOffice, LocalDate releaseDate) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.boxOffice = boxOffice;
		this.releaseDate = releaseDate;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(double boxOffice) {
		this.boxOffice = boxOffice;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("MovieId: ");
		str.append(movieId);
		str.append("\t\tTitle: ");
		str.append(title);
		str.append("\t\tBox Office Collection: ");
		str.append(boxOffice);
		str.append("\t\tRelease Date: ");
		str.append(releaseDate);
		
		return str.toString();
	}

	@Override
	public int compareTo(Movie o) {
		String firstTitle = this.getTitle();
		String secondTitle = o.getTitle();
		return firstTitle.compareTo(secondTitle);
	}
	
	
	
}
