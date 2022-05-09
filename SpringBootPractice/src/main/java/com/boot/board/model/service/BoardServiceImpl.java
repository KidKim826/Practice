package com.boot.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.board.model.dao.BoardDao;
import com.boot.board.model.dto.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void writeBoard(Board board) { //file관련
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		Board b = boardDao.selectOne(board.getId());
		b.setContent(board.getContent());
		b.setTitle(board.getTitle());
		boardDao.updateBoard(b);
	}

	@Override
	public void deleteBoard(int id) {//file관련 board를 id로 하나 잡아와서 file이 null이 아니면 지우는거로.
		boardDao.deleteBoard(id);
	}

	@Override
	public Board readBoard(int id) {
		this.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public Board readBoardById(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> readBoardList(HashMap<String, String> params) {
		return boardDao.selectList(params);
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		Board b = boardDao.selectOne(id);
		b.setViewCnt(b.getViewCnt()+1);
		boardDao.updateBoard(b);
	}
	
}
