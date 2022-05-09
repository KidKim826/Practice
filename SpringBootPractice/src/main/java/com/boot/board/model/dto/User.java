package com.boot.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	private int seq;
	private String id;
	private String pw;
	private String username;
	
}
