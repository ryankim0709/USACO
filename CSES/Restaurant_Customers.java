import java.util.Arrays;
import java.util.Scanner;
public class Restaurant_Customers {
	
	static class customer implements Comparable<customer>{
		int arrival = 0;
		int leave = 0;
		
		public customer (int arrive, int left) {
			arrival = arrive;
			leave = left;
		}
		
		public int compareTo(customer second) {
			
			if(arrival < second.arrival) {
				return -1;
			}
			
			if(leave < second.leave) {
				return 1;
			}
			return 0;
		}
		
		public void show() {
			System.out.println("Arrival: "+arrival +" leaving: "+leave);
		}
	}
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		
		int customers = sc1.nextInt();
		
		customer[] times = new customer[customers];
		
		for(int x = 0; x < customers;x++) {
			sc1.nextLine();
			times[x] = new customer(sc1.nextInt(),sc1.nextInt());
		}
		
		Arrays.sort(times);
		
		//for(customer x:times) {
		//	x.show();
		//}
		
		int min = 0;
		int total = 0;
		for(int x = 0; x < customers;x++) {
			if(times[x].arrival > min) {
				total ++;
				min = times[x].leave;
			}
		}
		System.out.println(total);
	}
}
