package com.boot.board.model.dao;

import java.util.HashMap;
import java.util.List;

import com.boot.board.model.dto.Board;

public interface BoardDao {
	//C
	void insertBoard(Board board);
	//R
	Board selectOne(int id);
	//U
	void updateBoard(Board board);
	//D
	void deleteBoard(int id);
	//selecList
	List<Board> selectList(HashMap<String, String> params);
	
}
