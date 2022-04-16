import java.util.Arrays;
import java.util.Scanner;


public class ABC_simple {
	public static void main(String args[]) {
		int [] nums = new int[7];
		String input = "";
		int num = 0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Which numbers would you like in your list?");
		input = scan.nextLine();
		Scanner scan1 = new Scanner(input);
		
		while (scan1.hasNext()) {
			num = scan1.nextInt();
			nums[count] = num;
			count ++;
		}
		Arrays.sort(nums);
		int a = nums[0];
		int b = nums[1];
		int c = nums[6] -a - b;
		System.out.println("A: "+a+ " B: "+b+" C: "+c);
	}
}