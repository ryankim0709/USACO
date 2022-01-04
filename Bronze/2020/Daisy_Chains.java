import java.util.Scanner;

public class Daisy_Chains {
	public static void main(String args[]) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many flowers are in the garden?");
		int len = scan.nextInt();
		int[] flower_pedals = new int[len];
		int count = 0;
		
		Scanner scan2 = new Scanner(System.in);
		System.out.print("Number of pedals per flower as a list");
		String input = scan2.nextLine();
		Scanner scan1 = new Scanner(input);
		
		while(scan1.hasNext()) {
			flower_pedals[count] = scan1.nextInt();
			count ++;
		}
		
		count = 0;
		for (int i = 0; i < len; i ++) {
			for (int j = i; j < len; j++) {
				if (check(i,j,flower_pedals)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	public static boolean check(int i, int j, int[] nums) {
		double sum = 0;
		
		for (int x = i; x <= j;x++) {
			sum = sum + nums[x];
		}
		sum = sum / (j-i + 1);
		for (int x = i; x <= j;x++) {
			if (nums[x] == sum) {
				return true;
			}
		}		
		return false;
	}
}