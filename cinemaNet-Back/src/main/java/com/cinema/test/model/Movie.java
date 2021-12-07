package com.cinema.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movie {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(unique=true, name="Movie_name",length=50,nullable=false)
	 private String movieName;
	 @Column(unique=false,name="Gendre",length=20,nullable=false)
	 private String gendre;
	 @Column (unique=false,name="Sinopsis",length=300,nullable=false)
	 private String sinopsis;
	 @Column (unique=false,name="format",length=10,nullable=false)
	 private String format;
	 @Column (unique=false,name="length",length=10,nullable=false)
	 private String length;
	 @Column (unique=false,name="functions",length=50,nullable=false)
	 private String functions;
	 @Column (unique=false,name="poster_Url",length=200,nullable=false)
	 private String posterUrl;
	 
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGendre() {
		return gendre;
	}
	public void setGendre(String gendre) {
		this.gendre = gendre;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public String getPosterUrl() {
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	 
}
