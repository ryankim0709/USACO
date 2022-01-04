import java.util.Scanner;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class hps {
	public static void main(String args[]) throws IOException {
		Scanner sc1 = new Scanner(new File("./hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./hps.out")));
		int num_games = sc1.nextInt();
		int one_two = 0;
		int one_three = 0;
		int two_one = 0;
		int two_three = 0;
		int three_one = 0;
		int three_two = 0;
		for(int x = 0; x < num_games;x++) {
			int first = sc1.nextInt();
			int second = sc1.nextInt();
			if(first == second) {
				continue;
			}
			else if(first == 1 && second == 2) {
				one_two ++;
			}
			else if(first == 1 && second == 3) {
				one_three ++;
			}
			else if(first == 2 && second == 1) {
				two_one ++;
			}
			else if(first == 2 && second == 3) {
				two_three ++;
			}
			else if(first == 3 && second == 1) {
				three_one ++;
			}
			else {
				three_two ++;
			}
		}
		TreeSet<Integer> poss = new TreeSet<>();
		poss.add(three_two+one_three+two_one);
		poss.add(three_one+two_three+one_two);
		poss.add(one_three+two_one+three_two);
		poss.add(one_two+three_one+two_three);
		poss.add(three_one+two_three+one_two);
		poss.add(three_two+one_three+two_one);
		pw.print(poss.last());
		pw.close();
	}
}
