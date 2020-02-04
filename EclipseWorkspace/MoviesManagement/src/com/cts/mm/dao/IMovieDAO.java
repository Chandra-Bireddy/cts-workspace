package com.cts.mm.dao;

import java.util.List;

import com.cts.mm.exception.MovieException;
import com.cts.mm.model.Movie;

public interface IMovieDAO {
	String add(Movie movie) throws MovieException;
	boolean remove(String movieId) throws MovieException;
	Movie get(String movieId) throws MovieException;
	List<Movie> getAll() throws MovieException;
	boolean update(Movie movie) throws MovieException;
	public void persist() throws MovieException;
}
