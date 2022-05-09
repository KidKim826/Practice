package com.boot.board.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.board.model.dto.User;
import com.boot.board.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("login")
	public String login(HttpSession session, String id, String pw) throws Exception {
		User user = userService.login(id, pw);
		if(user != null)
			session.setAttribute("username", user.getUsername());
		System.out.println(user);
		return user!= null? "redirect:/":"redirect:/user/login";
	}
	
	@GetMapping("join")
	public String joinForm() {
		return "user/join";
	}
	
	@PostMapping("join")
	public String join(User user, String msg) {
		try {
			userService.join(user, msg);
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/user/join";
		}
		return "redirect:/user/login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; //home으로 가기
	}
}
