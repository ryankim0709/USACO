import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Social_Distancing_I {
	public static void main(String[] args) {
		Scanner sc1;
		
		try {
			sc1 = new Scanner(new File("/socdist1_bronze_open20/5.in"));
			int length = sc1.nextInt();
			sc1.nextLine();
			String available = sc1.next();
			int[] difference = new int[length + 1];
			for(int x = 0; x < length;x++) {
				difference[x] = 0;
			}
			int first_1 = 0;
			int second_1 = -1;
			int elements = 0;

			for(int x = 1; x < length;x++) {
				if(available.charAt(x) == '1') {
					second_1 = x;
					elements ++;
					difference[x] = second_1 - first_1;
					System.out.print(difference[x]+" ");
					first_1 = second_1;
				}
			}
			difference[length] = length - available.lastIndexOf('1') - 1;//REVIST IF ERROR OCCURS
			System.out.println(difference[length]);
			Arrays.sort(difference);
			//for(int x:difference) {
			//	System.out.print(x+" ");
			//}
			int max = difference[length];
			int second_max = difference[length - 1];
			System.out.println();
			
			if(max != 0 && second_max != 0) {// DIFFERENT
				System.out.println(find_max(max,second_max));
			}
			
			else if(max != 0 && second_max == 0) {
				if(second_1 == -1) {
					System.out.println((int) (max * 0.5));
				}
				else if(max == length) { //0000000000
					System.out.println(length - 1);
				}
				else {
					System.out.println("HERE");
					System.out.println((int) (max * 0.25) + 1);
				}
			}
			
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static int find_max(int max,int second_max) {
		
		if((int) (second_max*0.5) > (int) (max *0.25)) {
			return (int) (second_max*0.5);
		}
		else {
			return (int) (max*0.25);
		}
	}
}