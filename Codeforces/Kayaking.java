import java.util.Arrays;
import java.util.Scanner;
public class Kayaking {
	public static void main(String[] args) {
		 Scanner sc1 = new Scanner(System.in);
		 int people = sc1.nextInt() * 2;
		 
		 int[] weights = new int[people];
		 
		 sc1.nextLine();
		 for(int x = 0; x < people; x++) {
			 weights[x] = sc1.nextInt();
		 }
		 
		 Arrays.sort(weights);
		 
		 int summ = 0;
		 
		 int sum = weights[people - 1];

		 for(int x = 0; x < people - 1;x++) {
			 for(int y = x + 1; y < people;y++) {
				 
				 summ = sum(weights,x,y,people);
				 
				 if(summ < sum) {
					 sum = summ;
				 }
				 
			 }
		 }
		 System.out.println(sum);
	}
	
	public static int sum(int[] weights, int first,int second,int people) {
		
		int start = 0;
		int end = 0;
		
		int sum = 0;
		for(int x = 0; x < people - 1;x++) {
			
			if(x == first && x == people - 2) {
				return sum;
			}
			if(x == first || x == second) {
				while((x == first || x == second) && x != people - 2) {
					x++;
				}
			}
			start = weights[x];
			
			if(x + 1 == first || x + 1 == second) {
				while((x + 1 == first || x + 1 == second) && x != people - 2) {
					x ++;
				}
			}
			end = weights[x + 1];
			x++;
			sum = sum + (end - start);
		}
		return sum;
	}
}
