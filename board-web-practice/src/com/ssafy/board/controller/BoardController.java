package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;


/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardDao dao;
    
    public BoardController() {
    	dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String act = request.getParameter("act");
		
		switch(act) {
		case "list":
			list(request, response);
			break;
		case "detail":
			detail(request, response);
			break;
		case "write":
			write(request, response);
			break;
		case "writeform":
			writeform(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "updateform":
			updateform(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		}
	}
	
	
	
	
	


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		dao.deleteBoard(id);
		request.setAttribute("board", dao.selectBoard());
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}


	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		dao.updateViewCnt(id);
		request.setAttribute("board", dao.selectBoardById(id));
		request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.setId(Integer.parseInt(request.getParameter("id")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		dao.updateBoard(board);
		response.sendRedirect("board?act=list");
		
	}


	private void updateform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("board", dao.selectBoardById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/board/updateform.jsp").forward(request, response);
	}


	private void writeform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/board/writeform.jsp").forward(request, response);
	}


	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Board board = new Board();
		
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		dao.insertBoard(board);
		response.sendRedirect("board?act=list");
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", dao.selectBoard());
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		
	}

	
}
