
import java.util.Scanner;
import java.io.File;;

public class The_Lost_Cow {
	public static void main(String args[]) {
	int John_start = 0; // Where farmer John Starts
	int Bessie_start = 0;// Where Bessie is
	int John_goal = 0;// Where farmer John wants to move to each turn
	int John_current = 0;// Where farmer John is currently at
	int John_moves = 0;
	boolean add = true;
	boolean bessie_found = false;
	Scanner sc1;
	try {
		sc1 = new Scanner(new File("/Users/youjungkim/DropBox/ryankim/usaco/lostcow_bronze_open17/9.in"));
		John_start = sc1.nextInt();
		Bessie_start = sc1.nextInt();
		John_current = John_start; // farmer John is currently where he starts
	}
	catch(Exception e) {
		e.getStackTrace();
		}
	int moves = 1;
	boolean John_Greater_Bessie = John_start > Bessie_start;
	
	while(!bessie_found) {
		
		if (add) {
			John_goal = John_start + moves;
			// check if this goal is over where Bessie is
			// if not, move to the square
			if (John_goal >= Bessie_start && !John_Greater_Bessie) {
				John_moves = John_moves + Math.abs(John_current - Bessie_start);
				bessie_found = true;
				break;
			}
			John_moves = John_moves + Math.abs(John_goal - John_current);
			John_current = John_goal;
			add = false;
			moves = moves * 2;
			}
		else {
			John_goal = John_start - moves;
			if (John_goal <= Bessie_start && John_Greater_Bessie) {
				John_moves = John_moves + Math.abs(John_current - Bessie_start);
				bessie_found = true;
				break;
				
			}

			John_moves = John_moves + Math.abs(John_current - John_goal);
			John_current = John_goal;
			add = true;
			moves = moves * 2;
			}
		}
	System.out.println(John_moves);
	}
}