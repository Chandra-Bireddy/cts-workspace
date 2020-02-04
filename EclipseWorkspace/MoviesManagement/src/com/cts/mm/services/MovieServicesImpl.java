package com.cts.mm.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.mm.dao.IMovieDAO;
//import com.cts.mm.dao.MovieCollectionDAO;
import com.cts.mm.dao.MovieIODAO;
import com.cts.mm.exception.MovieException;
import com.cts.mm.model.Movie;

public class MovieServicesImpl implements IMovieServices{
	
	private IMovieDAO movieDao;
	
	public IMovieDAO getDao() {
		return movieDao;
	}
	
	public MovieServicesImpl()throws MovieException{
		movieDao= new MovieIODAO();
	}

	public boolean isValidMovieId(String mId) {
		Pattern movieIdPattern = Pattern.compile("[A-Z]\\d{5}");
		Matcher movieIdMatcher = movieIdPattern.matcher(mId);
		return movieIdMatcher.matches();
	}
	
	public boolean isValidMovieTitle(String name) {
		Pattern movieNamePattern = Pattern.compile("[A-Za-z]\\w{2,30}");
		Matcher movieNameMatcher = movieNamePattern.matcher(name);
		return movieNameMatcher.matches();
	}
	
	public boolean isValidReleaseDate(LocalDate date) {
		LocalDate today = LocalDate.now();
		return today.isAfter(date)||date.equals(today);
	}
	
	public boolean isValidBoxOffice(double earning) {
		return earning>=1000;
	}
	
	public boolean isValidMovie(Movie movie) throws MovieException {
		boolean isValid= false;
		
		List<String> errMsgs = new ArrayList<>();
		if(!isValidMovieId(movie.getMovieId()))
			errMsgs.add("Movie id should start with a Capital Letter followed by 4 digits");
		if(!isValidMovieTitle(movie.getTitle()))
			errMsgs.add("Movie name should not contain any special characters or spaces");
		if(!isValidReleaseDate(movie.getReleaseDate()))
			errMsgs.add("Movie's date of release cannot be today");
		if(!isValidBoxOffice(movie.getBoxOffice()))
			errMsgs.add("Movie's box office collection should be above Rs.1000");
		if(errMsgs.size()==0)
			isValid= true;
		else
			throw new MovieException(errMsgs.toString());
		
		return isValid;
	}
	
	@Override
	public String add(Movie movie) throws MovieException {
		String movieId= null;
		if(movie != null && isValidMovie(movie))
			movieId = movieDao.add(movie);
		
		return movieId;
	}

	@Override
	public boolean remove(String movieId) throws MovieException {
		boolean isDone= false;
		if(movieId != null && isValidMovieId(movieId)) {
			movieDao.remove(movieId);
			isDone = true;
		}else {
			throw new MovieException("Movie with id "+movieId+" not found");
		}
		return isDone;
	}

	@Override
	public Movie get(String movieId) throws MovieException {
	
		return movieDao.get(movieId);
	}

	@Override
	public List<Movie> getAll() throws MovieException {
		
		return movieDao.getAll();
	}

	@Override
	public boolean update(Movie movie) throws MovieException {
		boolean isDone = false;
		if(movie!=null && isValidMovie(movie))
			isDone= movieDao.update(movie);
		return isDone;
	}

	@Override
	public void persist() throws MovieException {
		
		movieDao.persist();
		
	}
	

}
