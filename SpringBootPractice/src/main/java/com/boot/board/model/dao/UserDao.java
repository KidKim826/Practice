package com.boot.board.model.dao;

import com.boot.board.model.dto.User;

public interface UserDao {
	//회원가입 (추가)
	void insertUser(User user) throws Exception;
	
	//로그인
	User selectById(String id) throws Exception;
}
