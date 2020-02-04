package com.cts.mm.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cts.mm.exception.MovieException;
import com.cts.mm.model.Movie;
import com.cts.mm.model.MovieMenu;
import com.cts.mm.services.IMovieServices;
import com.cts.mm.services.MovieDateComparator;
import com.cts.mm.services.MovieIdComparator;
import com.cts.mm.services.MovieServicesImpl;

public class MovieUI {
	private static IMovieServices movieService;
	private static Scanner sc;
	private static DateTimeFormatter dtFormatter;
	
	public static void main(String[] args) {
		
		try {
			movieService = new MovieServicesImpl();
		}catch (MovieException e) {
			e.printStackTrace();
		}
		
		sc = new Scanner(System.in);
		dtFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		MovieMenu menu = null;
		
		while(menu != MovieMenu.QUIT) {
			System.out.println("Choice \tMenu Item");
			System.out.println("----------------------------");
			for(MovieMenu m : MovieMenu.values()) {
				System.out.println(m.ordinal()+"\t"+m.name());
			}
			System.out.println("Choice: ");
			int choice = -1;
			if(sc.hasNext())
				choice = sc.nextInt();
			else {
				sc.next();
				System.out.println("Please choose a choice displayed");
				continue;
			}
			
			if(choice > 0 || choice <= MovieMenu.values().length ) {
				
				menu = MovieMenu.values()[choice];
				switch (menu) {
				case ADD:
					doAdd();
					break;
				case REMOVE:
					doRemove();
					break;
				case SEARCH:
					doSearch();
					break;
				case LIST:
					doList();
					break;
				case QUIT:
					System.out.println("The program has ended");
					break;
				
				}
			}else
				System.out.println("Wrong choice");
		}
		sc.close();
		try {
			movieService.persist();
		} catch (MovieException e) {
			e.printStackTrace();
		}
	}
	
	private static void doAdd() {
		try {
			Movie movie = new Movie();
			System.out.print("Movie Id: ");
			movie.setMovieId(sc.next());
			System.out.print("Movie Title: ");
			movie.setTitle(sc.next());
			System.out.print("Release Date: ");
			String relDate = sc.next();
			try {
				movie.setReleaseDate(LocalDate.parse(relDate, dtFormatter));
			}catch (DateTimeException exp) {
				throw new MovieException("Date must be in the format dd-MM-yyyy");
			}
			System.out.println("Box Office Collection: ");
			if(sc.hasNextDouble())
				movie.setBoxOffice(sc.nextDouble());
			else {
				sc.next();
				throw new MovieException("Box Office Collection is a number");
			}
			
			String movieId = movieService.add(movie);
			System.out.println("Movie is added with ID: "+movieId);
		}catch(MovieException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doList() {
		List<Movie> movie;
		try {
			movie = movieService.getAll();
			if(movie.size()==0) {
				System.out.println("No movies to display");
			}else {
				Collections.sort(movie);
				System.out.println("Movie list sorted according to their Titles:");
				for(Movie m: movie)
					System.out.println(m);
				System.out.println("------------------------------------------------------------------------------------------------------------");
				Collections.sort(movie, new MovieDateComparator());
				System.out.println("Movie list sorted according to the release dates");
				for(Movie m: movie)
					System.out.println(m);
				System.out.println("------------------------------------------------------------------------------------------------------------");
				Collections.sort(movie, new MovieIdComparator());
				System.out.println("Movie list sorted according to the IDs");
				for(Movie m: movie)
					System.out.println(m);
				System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MovieException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doSearch() {
		System.out.print("Movie Id: ");
		String movieId = sc.next();
		try {
			Movie movie = movieService.get(movieId);
			if(movie != null) {
				System.out.println(movie);
			} else {
				System.out.println("No such Movies");
			}
		}catch (MovieException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doRemove() {
		System.out.println("Movie Id: ");
		String mId = sc.next();
		try {
			Movie movie = movieService.get(mId);
			if(movie!=null) {
				movieService.remove(mId);
				System.out.println("Movie is deleted");
			} else {
				System.out.println("No such movie");
			}
		}catch (MovieException exp) {
			System.out.println(exp.getMessage());
		}
	}
}
