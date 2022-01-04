import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Block_Game {
	public static void main(String args[]) {
		Scanner sc1;
		ArrayList<String[]> word_boards = new ArrayList<>();
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] answer = new int[26];
		String[] board = new String[2];
		int length = 0;
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/blocks_bronze_dec16/2.in"));
			length = sc1.nextInt();
			sc1.nextLine();
			for (int x = 0; x < length;x++) {
				for (int y = 0; y < 2;y++) {
					board[y] = sc1.next();
				}
				word_boards.add(board.clone());
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		for (int x = 0; x < 26;x++) {
			answer[x] = check_char(word_boards,alphabet[x]);
		}
		for (int x:answer) {
			System.out.println(x);
		}
	}
	
	public static int check_char(ArrayList<String[]> word_board,char check) {
		int char_appear = 0;
		
		for (String[] a :word_board) {
			if (check_num_char(a[0],check) > check_num_char(a[1],check)) {
				char_appear = char_appear + check_num_char(a[0],check);
			}
			else {
				char_appear = char_appear + check_num_char(a[1],check);
			}
		}
		return char_appear;
	}
	public static int check_num_char(String word,char check_letter) {
		int count = 0;
		for (int x = 0; x < word.length();x++) {
			if (word.charAt(x) == check_letter) {
				count ++;
			}
		}
		return count;
	}
}