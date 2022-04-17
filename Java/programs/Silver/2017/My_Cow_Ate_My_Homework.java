import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class My_Cow_Ate_My_Homework {
	public static void main(String[] args) throws IOException {
		
		/*Slowest time: 2711
		 Basic function: Create three arrays, the test scores, the prefix array of the sum of scores, and the worst scores.
		 Then use the arrays to find the totals, then loop through an array containing all the test scores, and output.
		 */
		
		
		Scanner sc1 = new Scanner(new File("./homework.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./homework.out")));
		int scores = sc1.nextInt();
		
		double[] scores_list = new double[scores];
		double[] score_sum = new double[scores];
		double[] smallest = new double[scores];
		
		sc1.nextLine();
		double score = 0;
		for(int x = 0; x < scores;x++) {
			score = sc1.nextDouble();
			scores_list[x] = score;
		}
		
		score_sum[scores - 1] = scores_list[scores - 1];
		smallest[scores - 1] = scores_list[scores - 1];
		for(int x = scores - 2; x >= 0; x--) {
			score_sum[x] = scores_list[x] + score_sum[x+1];
			
			if(scores_list[x] < smallest[x+1]) {
				smallest[x] = scores_list[x];
			}
			else {
				smallest[x] = smallest[x+1];
			}
		}

		double total = 0;
		double[] total_scores = new double[scores - 2];
		double max = 0;
		
		for(int x = 1; x <= scores - 2;x++) {
			total = (score_sum[x] - smallest[x])/(scores-x-1);
					
			total_scores[x-1] = total;
			
			if(total > max) {
				max = total;
			}
		}

		for(int x = 0; x < scores - 2;x++) {
			if(total_scores[x] == max) {
				pw.println(x+1);
			}
		}
		pw.close();
	}
}
