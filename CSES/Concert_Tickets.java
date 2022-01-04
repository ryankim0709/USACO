import java.util.Scanner;
import java.util.TreeMap;

public class Concert_Tickets {
	public static void main(String args[]) {
		Scanner sc1 = new Scanner(System.in);
		int[] max = null;
		TreeMap<Integer,Integer> prices = new TreeMap<>();
		
		int tickets = sc1.nextInt();
		int customers = sc1.nextInt();
		max = new int[customers];
		
		for(int x = 0; x < tickets;x++) {
			int num = sc1.nextInt();
			if(prices.containsKey(num)) {
				prices.put(num, prices.get(num) + 1);
			}
			else {
				prices.put(num, 1);
			}
		}
		for(int x = 0; x < customers;x++) {
			max[x] = sc1.nextInt();
		}
		
		for(int x:max) {
			if(prices.lowerKey(x+1) != null) {
				int number = prices.lowerKey((x + 1));
				
				System.out.println(number);
				prices.put(number, prices.get(number) - 1);
				
				if(prices.get(number) == 0) {
					prices.remove(number);
				}
			}
			else {
				System.out.println(-1);
			}
		}
	}
}
