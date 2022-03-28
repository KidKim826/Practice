package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/board")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao dao;

	public UserController() {
		dao = MyAppSqlConfig.getSession().getMapper(UserDao.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}

		String act = request.getParameter("act");
		switch (act) {
		case "login":
			login(request, response);
			break;
		case "logout":
			logout(request, response);
			break;
		case "signup":
			signup(request, response);
			break;
		}

	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();

		user.setUserId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));

		if (dao.selectUserById(user) == null) {
			dao.insertUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		} else {
			request.setAttribute("idalert", true);
			request.getRequestDispatcher("/board/join.jsp").forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = new User();
		user.setUserId(id);
		user.setPassword(password);

		if (dao.selectUserById(user).getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		} else {
			request.setAttribute("loginAlert", true);
			request.getRequestDispatcher("/board/signin.jsp").forward(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		response.sendRedirect("/board/list.jsp");
	}

}
