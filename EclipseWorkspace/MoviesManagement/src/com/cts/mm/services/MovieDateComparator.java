package com.cts.mm.services;

import java.util.Comparator;

import com.cts.mm.model.Movie;

public class MovieDateComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getReleaseDate().compareTo(o2.getReleaseDate());
	}

}
