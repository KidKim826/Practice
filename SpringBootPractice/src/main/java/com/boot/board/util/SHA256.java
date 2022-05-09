package com.boot.board.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	public String getHash(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256"); 
		// SHA(Secure Hash Algorithm, 안전한 해시 알고리즘)
		// 패스워드는 사용자 본인만 알아야 하므로 암호화 할때도 복호화가 불가능한 단방향 방식으로 암호화 해야한다.
		// 해시 함수가 출력하는 암축된 문장을 다이제스트(Digest) 라고 하는데,
		// SHA-2가 생성하는 다이제스트 출력 길이는 224, 256, 384, 512 bit로 다양하다
		// 이때 256bit의 출력 길이를 갖는 SHA-2을 SHA-256이라고 부른다.
		// 양방향 (암호화 & 복호화) 가능한 거는
		// Cipher AES(Advanced Encryption Standard), RSA 가 있다 (AES-256) 
		md.update(msg.getBytes());
		return byteToHex(md.digest());
	}
	private String byteToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes)
			builder.append(String.format("%02x", b));
		return builder.toString();
	}
}
