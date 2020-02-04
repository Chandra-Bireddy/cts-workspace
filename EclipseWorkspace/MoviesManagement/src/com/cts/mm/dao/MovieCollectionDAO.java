package com.cts.mm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.mm.exception.MovieException;
import com.cts.mm.model.Movie;

public class MovieCollectionDAO implements IMovieDAO{
	
	private Map<String, Movie> movie;
	
	public MovieCollectionDAO() {
		movie = new TreeMap<>();
	}

	@Override
	public String add(Movie movie) throws MovieException {
		String movieId= null;
		if(movie!=null) {
			movieId= movie.getMovieId();
			this.movie.put(movieId, movie);
		}
		return movieId;
	}

	@Override
	public boolean remove(String movieId) throws MovieException {
		boolean isDone= false;
		//Movie movie= new Movie();
		if(movieId!=null) {
			movie.remove(movieId);
			isDone= true;
		}
		return isDone;
	}

	@Override
	public Movie get(String movieId) throws MovieException {
		
		return movie.get(movieId);
	}

	@Override
	public List<Movie> getAll() throws MovieException {
		// TODO Auto-generated method stub
		return new ArrayList<>(movie.values());
	}

	@Override
	public boolean update(Movie movie) throws MovieException {
		// TODO Auto-generated method stub
		boolean isDone= false;
		if(movie!=null) {
			String movieId= movie.getMovieId();
			this.movie.replace(movieId, movie);
		}
		return isDone;
	}

}
