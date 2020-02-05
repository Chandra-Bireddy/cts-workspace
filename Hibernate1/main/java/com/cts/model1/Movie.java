package com.cts.model1;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movie implements Comparable<Movie>{
@Id
private int mId;
private String Mname;
@ManyToMany(mappedBy="movies")
private Set<Artist> artists;
public Movie() 
{
	}
public Movie(int mId, String mname, Set<Artist> artists) {
	super();
	this.mId = mId;
	Mname = mname;
	this.artists = artists;
}
public int getmId() {
	return mId;
}
public void setmId(int mId) {
	this.mId = mId;
}
public String getMname() {
	return Mname;
}
public void setMname(String mname) {
	Mname = mname;
}
public Set<Artist> getArtists() {
	return artists;
}
public void setArtists(Set<Artist> artists) {
	this.artists = artists;
}
public int compareTo(Movie o) {
	return (this.mId<o.mId?-1:(this.mId>o.mId?1:0));
}
}
