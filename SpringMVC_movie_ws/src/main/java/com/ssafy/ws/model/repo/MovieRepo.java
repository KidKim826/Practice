package com.ssafy.ws.model.repo;

import java.util.List;

import com.ssafy.ws.dto.Movie;

public interface MovieRepo {
	int insert(Movie movie);
	
	Movie searchById(int id);

	List<Movie> selectAll();

	List<Movie> searchByTitle(String title);
}
