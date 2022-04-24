package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.dto.Movie;
import com.ssafy.ws.model.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private MovieService mService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@GetMapping("regist") 
	public String regist() {
		return "regist";
	}

	@PostMapping("regist")
	public String result(Movie movie, MultipartFile upload_file, Model model) {
		String uploadPath = servletContext.getRealPath("/file");
		String fileName = upload_file.getOriginalFilename();
		File target = new File(uploadPath, fileName);
		if (!new File(uploadPath).exists())
			new File(uploadPath).mkdirs();
		try {
			FileCopyUtils.copy(upload_file.getBytes(), target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("fileName", fileName);
		model.addAttribute("movie", movie);
		return "result";
	}
	
	@GetMapping("list") 
	public String list(Movie movie, Model model) {
		List<Movie> movies = mService.selectAll();
		model.addAttribute("movies", movies);
		return "list";
	}
	
}
