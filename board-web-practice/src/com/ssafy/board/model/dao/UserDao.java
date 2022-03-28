package com.ssafy.board.model.dao;

import com.ssafy.board.model.dto.User;

public interface UserDao {
	
	//등록
	public void insertUser(User user);
	
	//회원 조회
	public User selectUser(User user);
	
	//id로 회원 조회
	public User selectUserById(User user);
	
}
