package com.boot.board.exception;

public class PWIncorrectException extends Exception{
	//servletcontext.xml에 추가 해서 이쪽에서 안내되게끔.
	public PWIncorrectException() {
		super("비밀번호가 틀립니다.");
	}
}
