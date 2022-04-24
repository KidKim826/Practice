package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Movie;
import com.ssafy.ws.model.repo.MovieRepo;

@Service("MovieService")
public class MovieServiceImpl implements MovieService{
	//그 소통한 movieRepo갖고 놀아서 조작을 하겠다.
	//Autowired는 싱글턴 같은 효과.
	
	
	@Autowired
	private MovieRepo movieRepo; //입벌리고 있어

	public MovieRepo getMovieRepo() {
		return movieRepo;
	}
	
	@Override
	public List<Movie> selectAll() {
		return movieRepo.selectAll();
	}

	@Override
	public Movie searchById(int id) {
		return movieRepo.searchById(id);
	}

	@Override
	public List<Movie> searchByTitle(String title) {

		return movieRepo.searchByTitle(title);
	}
//	@Transactional
//	@Override
//	public void registerClass(List<Student> list) throws Exception {
//		// TODO Auto-generated method stub
//		for(Student s : list)
//			studentRepo.insertStudent(s);
//	}

	@Override
	public int insert(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.insert(movie);
	}

}
