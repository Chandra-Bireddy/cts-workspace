package com.cts.mm.services;

import java.util.Comparator;

import com.cts.mm.model.Movie;

public class MovieIdComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		// TODO Auto-generated method stub
		return o1.getMovieId().compareTo(o2.getMovieId());
	}

}
