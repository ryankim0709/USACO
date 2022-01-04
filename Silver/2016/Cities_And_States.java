import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class Cities_And_States {
	public static void main(String args[]) {
		try {
			Scanner sc1 = new Scanner(new File("./citystate.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./citystate.out")));
			HashMap<String,Integer> city = new HashMap<>();
			int length = sc1.nextInt();
			
			for(int x = 0; x < length;x++) {
				String first = sc1.next().substring(0,2);
				String second = sc1.next();
				String finale = first + second;
				
				if(city.get(finale) == null) {
					city.put(finale, 1);
				}
				else {
					city.put(finale, city.get(finale) + 1);
				}
			}
			int count = 0;
			for(String x:city.keySet()) {
				String goal = reverse(x);
				if (city.get(goal) != null && !(x.substring(2,4).equals(goal.substring(2,4)))) {
					count = count  +(city.get(x) * city.get(goal));
				}
			}
			pw.println(count/2);
			pw.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static String reverse(String a) {
		String start = a.substring(0,2);
		String end = a.substring(2,4);
		return end + start;
	}
}