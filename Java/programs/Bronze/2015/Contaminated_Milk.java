import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
public class Contaminated_Milk {
	public static void main(String[] args) throws IOException{
		/*
		 Slowest time: 537 ms
		 Basic function: All we have to do is find the first person who got sick, and whatever milk's he drank before he got
		 sick are the possible milk possibilities. Thats exactly what this does. The friend == 0 conditions takes care of if no one
		 got sick during the party, then we have to try every milk what were drank by all the sick people.
		 */
		Scanner sc1 = new Scanner(new File("./badmilk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./badmilk.out")));
		int friends = sc1.nextInt();
		int milks = sc1.nextInt();
		int drank = sc1.nextInt();
		int sick = sc1.nextInt();
		
		HashMap<Integer,ArrayList<Integer>> milk_drank = new HashMap<>();
		HashMap<Integer,ArrayList<Integer>> time_drank = new HashMap<>();
		HashMap<Integer,Integer> sick_times = new HashMap<>();
		
		
		ArrayList<Integer> base = new ArrayList<>();
		for(int x = 0; x < friends;x++) {
			milk_drank.put(x+1, (ArrayList<Integer>) base.clone());
			time_drank.put(x+1, (ArrayList<Integer>) base.clone());
		}
		
		int friend = 0;
		int type = 0;
		int time = 0;
		for(int x = 0; x < drank;x++) {
			sc1.nextLine();
			friend = sc1.nextInt();
			type = sc1.nextInt();
			time = sc1.nextInt();
			
			milk_drank.get(friend).add(type);
			time_drank.get(friend).add(time);
		}
		
		int min = drank;
		int person = 0;
		friend = 0;
		
		for(int x = 0; x < sick;x++) {
			sc1.nextLine();
			person = sc1.nextInt();
			time = sc1.nextInt();
			sick_times.put(person, time);
			
			if(time < min) {
				min = time;
				friend = person;
			}
		}
		
		int max = 0;
		int milk_type = 0;
		
		int medications = 0;
		if(friend == 0) {

			for(int x:sick_times.keySet()) {
				base = milk_drank.get(x);
				
				for(int y:base) {
					medications = find_total(milk_drank,y);
					
					if(medications > max) {
						max = medications;
					}
				}
				
			}
		}
		
		else {
			ArrayList<Integer> earliest_sick = milk_drank.get(friend);
			ArrayList<Integer> earliest_time = time_drank.get(friend);

			for(int x = 0; x < earliest_sick.size();x++) {
				milk_type = earliest_sick.get(x);
				time = earliest_time.get(x);
				
				if(time < min && verify_milk(milk_type,milk_drank,time_drank,sick_times)) {
					medications = (find_total(milk_drank,milk_type));
					
					if(medications > max) {
						max = medications;
					}
				}
			}
		}
		pw.print(max);
		pw.close();
	}
	
	public static boolean verify_milk(int milk_type, HashMap<Integer,ArrayList<Integer>> milk_drank, 
			HashMap<Integer,ArrayList<Integer>> time_drank, HashMap<Integer,Integer> sick_times) {
		
		ArrayList<Integer> milks = new ArrayList<>();
		ArrayList<Integer> times = new ArrayList<>();
		int max = 0;
		
		for(int x:sick_times.keySet()) {
			milks = milk_drank.get(x);
			times = time_drank.get(x);
			max = sick_times.get(x);
			
			if(!(before_sick(milks,times, max,milk_type))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean before_sick(ArrayList<Integer> milks, ArrayList<Integer> times, int max, int type) {
		for(int x = 0; x < milks.size();x++) {
			if(milks.get(x) == type && times.get(x) < max) {
				return true;
			}
		}
		return false;
	}
	
	public static int find_total(HashMap<Integer,ArrayList<Integer>> milk_drank, int milk_type) {
		int total = 0;
		for(ArrayList<Integer> x:milk_drank.values()) {
			
			for(int y:x) {
				if(y == milk_type) {
					total ++;
					break;
				}
			}
			
		}
		return total;
	}
}
