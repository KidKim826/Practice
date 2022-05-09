package com.boot.board.model.service;

import java.util.HashMap;
import java.util.List;

import com.boot.board.model.dto.Board;

public interface BoardService {
	//C
	void writeBoard(Board board);
	
	//U
	void modifyBoard(Board board);
	
	//D
	void deleteBoard(int id);
	
	//Read 1 조회 
	Board readBoard(int id);
	
	//Read 2 조회 without viewCnt++
	Board readBoardById(int id);
	
	//Read 3 조회 list
	List<Board> readBoardList(HashMap<String, String> params);
	
	//viewCnt ++
	void updateViewCnt(int id);
	

}
