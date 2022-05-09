package com.boot.board.model.service;

import com.boot.board.model.dto.User;

public interface UserService {
	
	void join(User user, String msg) throws Exception;
	User login(String id, String pw) throws Exception;

}
