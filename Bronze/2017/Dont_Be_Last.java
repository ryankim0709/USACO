import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class Dont_Be_Last {
	public static void main(String args[]) {
		try {
			Scanner sc1 = new Scanner(new File("./notlast.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./notlast.out")));
			int length = sc1.nextInt();
			HashMap<String,Integer> cow_milk = new HashMap<>();
			cow_milk.put("Bessie", 0);
			cow_milk.put("Elsie", 0);
			cow_milk.put("Daisy", 0);
			cow_milk.put("Gertie", 0);
			cow_milk.put("Annabelle", 0);
			cow_milk.put("Maggie", 0);
			cow_milk.put("Henrietta", 0);
			for(int x = 0; x < length;x++) {
				sc1.nextLine();
				String cow = sc1.next();
				cow_milk.put(cow, cow_milk.get(cow) + sc1.nextInt());
			}
			//for(String a:cow_milk.keySet()) {
			//	System.out.println(a+" "+cow_milk.get(a));
			//}
			pw.print(find_second(cow_milk));
			pw.close();
			System.out.println(find_second(cow_milk));
		}
		catch(Exception e) {
			//System.out.println("Exception");
			e.getStackTrace();
		}
	}
	public static String find_second(HashMap<String,Integer> cow_milk) {
		String[] cows = {"Bessie","Elsie","Daisy","Gertie","Annabelle","Maggie","Henrietta"};
		int min  = cow_milk.get("Bessie");
		for(String a:cows) {
			if(cow_milk.get(a) < min) {
				min = cow_milk.get(a);
			}
		}
		//System.out.println(min);
		int second_min = 2147483647;
		for(String a:cows) {
			if (cow_milk.get(a) > min && cow_milk.get(a) < second_min) {
				second_min = cow_milk.get(a);
			}
		}
		if(second_min == 2147483647) {
			return "Tie";
		}
		//System.out.println(second_min);
		int count = 0;
		String solo = "";
		for(String a:cows) {
			//System.out.println(a);
			if(cow_milk.get(a) == second_min) {
				if(count == 1 && !(solo.equals(a))) {
					return "Tie";
				}
				count ++;
				solo = a;
				//System.out.println(a);
			}
		}
		return solo;
	}
}