import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Team_Tic_Tac_Toe {
	public static void main(String args[]) {
		Scanner sc1;
		char[][] ttt_board = new char[3][3];
		ArrayList<Character> single_win = new ArrayList<>();
		ArrayList<String> team_win = new ArrayList<>();
		
		try {
			sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/tttt_bronze_open18/10.in"));
			for (int x = 0; x < 3;x++) {
				String line = sc1.nextLine();
				for (int y = 0; y < 3;y++) {
					ttt_board[x][y] = line.charAt(y);
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		for (int x = 0; x < 3; x++) {
			if ((single_win_across(x,ttt_board) != '0') && !(single_win.contains(single_win_across(x,ttt_board)))) {
				single_win.add(single_win_across(x,ttt_board));
			}
			if ((single_win_down(x,ttt_board) != '0') && !(single_win.contains(single_win_down(x,ttt_board)))) {
				single_win.add(single_win_down(x,ttt_board));
			}
			if ((single_win_left_diagonal(ttt_board) != '0') && !(single_win.contains(single_win_left_diagonal(ttt_board)))) {
				single_win.add(single_win_left_diagonal(ttt_board));
			}
			if ((single_win_right_diagonal(ttt_board) != '0') && !(single_win.contains(single_win_right_diagonal(ttt_board)))) {
				single_win.add(single_win_right_diagonal(ttt_board));
			}

			if (!team_win_across(x,ttt_board).equals("0")  && !(team_win.contains(team_win_across(x,ttt_board)))) {
				team_win.add(team_win_across(x,ttt_board));
			}
			if (!team_win_down(x,ttt_board).equals("0")  && !(team_win.contains(team_win_down(x,ttt_board)))) {
				team_win.add(team_win_down(x,ttt_board));
			}
			if (!team_win_diag_right(ttt_board).equals("0")  && !(team_win.contains(team_win_diag_right(ttt_board)))) {
				team_win.add(team_win_diag_right(ttt_board));
			}
			if (!team_win_diag_left(ttt_board).equals("0")  && !(team_win.contains(team_win_diag_left(ttt_board)))) {
				team_win.add(team_win_diag_left(ttt_board));
			}
		}
		for (int x = 0; x < team_win.size();x++) {
			for (int y = 0; y < team_win.size();y++) {
				if (permute(team_win.get(y)).equals(team_win.get(x))) {
					team_win.remove(x);
				}
			}
		}
		System.out.println("Single: "+single_win.size());
		System.out.println("Team: "+team_win.size());
		
	}
	public static char single_win_across(int index,char[][] ttt_board) {
		if(ttt_board[index][0] == ttt_board[index][1] && ttt_board[index][0] == ttt_board[index][2]) {
			return ttt_board[index][0];
		}
		return '0';
	}
	public static char single_win_down(int index,char[][] ttt_board) {
		
		if(ttt_board[0][index] == ttt_board[1][index] && ttt_board[0][index] == ttt_board[2][index]) {
			return ttt_board[0][index];
		}
		return '0';
	}
	public static char single_win_left_diagonal(char[][] ttt_board) {
		
		if(ttt_board[0][0] == ttt_board[1][1] && ttt_board[0][0] == ttt_board[2][2]) {
			return ttt_board[0][0];
		}
		return '0';
	}
	public static char single_win_right_diagonal(char[][] ttt_board) {
		
		if(ttt_board[2][0] == ttt_board[1][1] && ttt_board[2][0] == ttt_board[2][0]) {
			return ttt_board[2][0];
		}
		return '0';
	}
	public static String team_win_across(int index,char[][] ttt_board) {
		ArrayList<Character> diffs = new ArrayList<>();
		int count = 0;
		
		for (int x = 0; x < 3; x ++) {
			
			if (!(diffs.contains(ttt_board[index][x]))) {
				if (diffs.size() == 2) {
					return "0";
				}
				else {
					count ++;
					diffs.add(ttt_board[index][x]);
				}
			}
		}
		if (count < 2) {
			return "0";
		}
		return new StringBuilder().append(diffs.get(0)).append(diffs.get(1)).toString();
	}
	public static String team_win_down(int index,char[][] ttt_board) {
		ArrayList<Character> diffs = new ArrayList<>();
		
		for (int x = 0; x < 3; x ++) {
			if (!(diffs.contains(ttt_board[x][index]))) {
				if (diffs.size() == 2) {
					return "0";
				}
				else {
					diffs.add(ttt_board[x][index]);
				}
			}
		}
		if (diffs.size() < 2) {
			return "0";
		}
		return new StringBuilder().append(diffs.get(0)).append(diffs.get(1)).toString();
	}
	public static String team_win_diag_right(char[][] ttt_board) {
		ArrayList<Character> diffs = new ArrayList<>();
		for (int x = 0; x < 3;x++) {
			if (!(diffs.contains(ttt_board[x][x]))) {
				if (diffs.size() == 2) {
					return "0";
				}
				else {
					diffs.add(ttt_board[x][x]);
				}
			}
		}
		if (diffs.size() < 2) {
			return "0";
		}
		return new StringBuilder().append(diffs.get(0)).append(diffs.get(1)).toString();
	}
	public static String team_win_diag_left(char[][] ttt_board) {

		ArrayList<Character> diffs = new ArrayList<>();
		int count = -1;
		
		for (int x = 2;x > -1;x--) {
			count ++;
			if (!(diffs.contains(ttt_board[count][x]))) {
				if (diffs.size() == 2) {
					return "0";
				}
				else {
					diffs.add(ttt_board[count][x]);
				}
			}
		}
		if (diffs.size() < 2) {
			return "0";
		}
		return new StringBuilder().append(diffs.get(0)).append(diffs.get(1)).toString();
	}
	public static String permute(String orig) {
		return new StringBuilder().append(orig.charAt(1)).append(orig.charAt(0)).toString();
	}
}