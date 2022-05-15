package CodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSliderUI;

public class Softeer_플레이페어암호2 {

	static String[] origin = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String Message = sc.next();
		String[] Key = sc.next().split("");

		String[][] cipher = new String[5][5];
		ArrayList<String> Code = new ArrayList<>();
		for (int i = 0; i < origin.length; i++) {
			if (i < Key.length && !Code.contains(Key[i])) {
				Code.add(Key[i]);
			}
		}
		for (int i = 0; i < origin.length; i++) {
			if (!Code.contains(origin[i])) {
				Code.add(origin[i]);
			}
		}

		int c = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cipher[i][j] = Code.get(c);
				c++;
			}
		}
		//출력 확인
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(cipher[i][j]);
			}
			System.out.println();
		}

		ArrayList<String> msgpw = new ArrayList<>();
		int start = 0;
		int idx = 0;
		for (int i = 0; i < Message.length() - 1; i++) {
			String msg = Message.substring(start, i + 2);
			if (msg.length() == 2) {
				String[] msgArr = msg.split("");
				if (msgArr[0].equals(msgArr[1]) && !msgArr[0].equals("X")) {
					msgpw.add(msgArr[0]);
					msgpw.add("X");
					start++;
				} else if (msgArr[0].equals(msgArr[1]) && msgArr[0].equals("X")) {
					msgpw.add(msgArr[0]);
					msgpw.add("Q");
					start++;
				} else {
					msgpw.add(msgArr[0]);
					msgpw.add(msgArr[1]);
					start++;
					start++;
					i++;
				}
			}
		}
		
		
//2개 HE LX LO WO RD SX SA FY SX SX SD SX SD DY YX YX 
// AASAA
//		AABBDD
//		AYPPLEE
		//HE LX LX LO OX OD DX
// PLAYFAIRCIPHERKEY
		
		System.out.println(start);

		if (start != Message.length()) {
			msgpw.add(Message.substring(Message.length() - 1));
			msgpw.add("X");
		}

		System.out.println();
		System.out.println(msgpw);

		StringBuilder sb = new StringBuilder();
		// 암호화 시작
		for (int k = 0; k < msgpw.size(); k += 2) {
			int idxX = 0;
			int idxY = 0;
			int idxX2 = 0;
			int idxY2 = 0;
			String word1 = msgpw.get(k);
			String word2 = msgpw.get(k + 1);
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (cipher[i][j].equals(word1)) {
						idxX = i;
						idxY = j;
					}
					if (cipher[i][j].equals(word2)) {
						idxX2 = i;
						idxY2 = j;
					}
				}
			}

			if (idxX == idxX2) { // 1에 해당 두 글자가 같은 행에 존재할 때
				if (idxY + 1 < 5) { // 열+1씩
					word1 = cipher[idxX][idxY + 1];
				} else {
					word1 = cipher[idxX][0];
				}
				if (idxY2 + 1 < 5) {
					word2 = cipher[idxX2][idxY2 + 1];
				} else {
					word2 = cipher[idxX2][0];
				}
			} else if (idxX != idxX2 && idxY == idxY2) { // 2에 해당. 1의 경우 만족하지 않으면서 두 글자가 같은 열에 존재할때.
				if (idxX + 1 < 5) { // 행+1씩
					word1 = cipher[idxX + 1][idxY];
				} else {
					word1 = cipher[0][idxY];
				}
				if (idxX2 + 1 < 5) {
					word2 = cipher[idxX2 + 1][idxY2];
				} else {
					word2 = cipher[0][idxY2];
				}
			} else if (idxX != idxX2 && idxY != idxY2) { // 3에 해당. 1, 2의 경우 만족하지 않으면서 서로 다른 행 열에 존재.
				// 행은 바꾸지 않고 열만 서로 바뀐다.
				word1 = cipher[idxX][idxY2];
				word2 = cipher[idxX2][idxY];

			}
			sb.append(word1 + word2);
		}
		System.out.println(sb);

	}

}
