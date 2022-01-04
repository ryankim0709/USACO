import java.util.Scanner;
import java.util.ArrayList;

public class ABC {
	public static void main(String args[]) {
		ArrayList<Integer> nums = new ArrayList <>();
		ArrayList<Integer> master = new ArrayList<>();
		int num = 0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		String input = "";
		boolean done = false;
		
		System.out.print("Which numbers would you like in your list?");
		input = scan.nextLine();
		Scanner scan1 = new Scanner(input);
		
		while (scan1.hasNext()) {
			num = scan1.nextInt();
			nums.add(num);
			count ++;
		}
		nums.sort(null);
		master = (ArrayList<Integer>) nums.clone();
		
		int a = nums.get(0);
		
		for (int b:master) {
			for (int c:master) {
				nums = (ArrayList<Integer>) master.clone();
				//System.out.println("A:"+a+" B:"+b+" C:"+c);
					
				if (a <= b && b <= c ) {
					test_input(a,0,nums);
					test_input(b,0,nums);
					test_input(c,0,nums);
					test_input(a,b,nums);
					test_input(a,c,nums);
					test_input(b,c,nums);
					if (nums.contains((a+b+c))) {
						nums.remove(nums.indexOf((a+b+c)));
					}
					if (nums.size() > 0) {
						continue;
					}
					else {
						if (!done) {
							System.out.println("A: "+a+" B: "+b+" C :"+c);
							done = true;
						}
					}
				}
			}
		}
	}
	
	public static boolean test_input(int a,int b,ArrayList<Integer> nums) {
		
		if (nums.contains(a+b)) {
			nums.remove(nums.indexOf(a+b));
			return true;
		}
		else {
			return false;
		}
	
	}
}