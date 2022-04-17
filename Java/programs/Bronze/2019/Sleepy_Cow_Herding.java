import java.util.*;
import java.io.*;

public class Sleepy_Cow_Herding {
	public static void main(String[] args) throws IOException{
		/*Slowest time: 205 ms
		 * Time complexity: O(1)
		 * Basic function: To start, I only assigned Bessie, Elsie, and Mildred first, second, and third
		 * respectively because that was the order in which the names were presented. This does not matter.
		 * For the minimum, we have 3 cases. The first case is if they are already in order in which the
		 * minimum number of moves is 0. The next case is if there is one tick mark or one space
		 * between the middle cow and one of the outer cows. In this case, we can just insert a cow into
		 * that last tick making three consecutive cows which results in 1 move total. Otherwise, we must
		 * make case 2 and insert our last cow. We put one cow one tick away from the middle cow, then just
		 * insert the lonely other cow into the last tick. 
		 * 
		 * For the maximum, the easiest way is to exclude one by one. We can use the sample input, 4,7, and 9.
		 * We first need to get the section with the largest amount of difference or ticks. Lets say that the first
		 * and second cow have a greater difference than the second and third cow. In this case, we would move the 
		 * third cow to position of second cow - 1 or position of first cow + 1. We would essentially keep decreasing
		 * our limit by one every movement, thus the maximum would be the maximum number of tick marks in between the
		 * second and first or second and third cow.
		 */
		BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int minimum;
		int maximum;
		
		int bessie = Integer.parseInt(st.nextToken());
		int elsie = Integer.parseInt(st.nextToken());
		int mildred = Integer.parseInt(st.nextToken());
		
		if(elsie == bessie + 1 && mildred == bessie + 2) {
			minimum = 0;
		}
		
		else if(elsie == bessie + 2 || mildred == elsie + 2) {
			minimum = 1;
		}
		
		else {
			minimum = 2;
		}
		
		maximum = Math.max(elsie - bessie-1, mildred - elsie - 1);
		
		pw.println(minimum);
		pw.print(maximum);
		pw.close();

	}
}
