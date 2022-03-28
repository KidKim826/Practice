package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardDao {
	
	//전체 조회
	public List<Board> selectBoard();
	//상세 조회
	public Board selectBoardById(int id);
	//등록
	public void insertBoard(Board board);
	//삭제
	public void deleteBoard(int id);
	//수정하기
	public void updateBoard(Board board);
	//조회수 증가
	public void updateViewCnt(int id);
	
}
