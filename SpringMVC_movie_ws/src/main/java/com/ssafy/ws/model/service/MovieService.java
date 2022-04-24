package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.dto.Movie;

public interface MovieService {
	public int insert(Movie movie);

	public Movie searchById(int id);
	
	public List<Movie> selectAll();

	public List<Movie> searchByTitle(String title);
}
