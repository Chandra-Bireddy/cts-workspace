package com.cts.mm.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.mm.exception.MovieException;
import com.cts.mm.model.Movie;

public class MovieIODAO implements IMovieDAO {

	public static final String DATA_STORE_FILE_NAME = "movies.dat";
	private Map<String, Movie> movie;
	
	@SuppressWarnings("unchecked")
	public MovieIODAO() throws MovieException{
		File file = new File(DATA_STORE_FILE_NAME);
		
		if (!file.exists()) {
			movie = new TreeMap<>();
		} else {
			try (ObjectInputStream fin = new ObjectInputStream(
					new FileInputStream(DATA_STORE_FILE_NAME))) {

				Object obj = fin.readObject();

				if (obj instanceof Map) {
					movie = (Map<String, Movie>) obj;
				} else {
					throw new MovieException("Not a valid DataStore");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new MovieException("Loading Data Failed");
			}
		}
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


	@Override
	public void persist() throws MovieException {
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(movie);
		} catch (IOException exp) {
			throw new MovieException("Saving Data Failed");
		}

	}

}
