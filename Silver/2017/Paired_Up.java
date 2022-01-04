import java.util.*;
import java.io.*;
public class Paired_Up {
	public static class cow implements Comparable<cow>{
		int time;
		int amount;
		public cow(int time, int amount) {
			this.time = time;
			this.amount = amount;
		}
		public int compareTo(cow b) {
			return this.time - b.time;
		}
	}
	public static void main(String[] args) throws IOException{
		/*Slowest time: 2473ms
		 * Basic function: Did not use two pointer despite being in two pointer section.
		 * The easiest way for me was to sort the cows by the amount of time taken to milk.
		 * Then when we match two cows, there are 3 cases(which you should figure out) that are
		 * feasible and we delete and reduce respective to those cases.
		 */
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		int dataPoints = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<cow> cows = new ArrayList<>();
		int time;
		int num;
		for(int x = 0; x < dataPoints; x++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			cows.add(new cow(time, num));
		}
		Collections.sort(cows);
		
		int ans = 0;
		int length;
		int info;
		while(cows.size() != 0) {
			length = cows.size()-1;
			info = cows.get(0).time + cows.get(length).time;
			ans = Math.max(ans, info);
			
			if(cows.get(0).amount == cows.get(length).amount) {
				if(length == 0) {
					cows.remove(0);
				}
				else {
					cows.remove(0);
					cows.remove(length-1);
				}
			}
			
			else if(cows.get(0).amount > cows.get(length).amount) {
				cows.get(0).amount -= cows.get(length).amount;
				cows.remove(length);
			}
			else {
				cows.get(length).amount -= cows.get(0).amount;
				cows.remove(0);
			}
		}
		pw.print(ans);
		pw.close();
		br.close();
	}
}