import java.util.*;
import java.io.*;

public class Why_Did_The_Cow_Cross_The_Road_III {
	public static void main(String[] args) throws IOException{
		
		/* Slowest time: 181 ms
		 * Time Complexity: O(n^2)
		 * Basic function: Since the time of questioning sill stay the same, the only factor that
		 * matters is how much time we save in between interrogations. Thus, to minimize this time,
		 * we want to question on a first come first serve. We have the time a cow enters, the time they take,
		 * and a boolean array to see if the cow has been processed. 
		 */
		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		
		int cows = Integer.parseInt(br.readLine());
		
		int btime = 0;
		int questionnaire = 0;
		
		int[] enter = new int[cows];
		int[] time = new int[cows];
		boolean[] processed = new boolean[cows];
		
		int times = 0;
		StringTokenizer st = null;
		for(int x = 0; x < cows; x++) {
			st = new StringTokenizer(br.readLine());
			
			btime = Integer.parseInt(st.nextToken());
			questionnaire = Integer.parseInt(st.nextToken());
			
			enter[x] = btime;
			time[x] = questionnaire;
		}
		
		int earliest = 100000001;
		int index = 0;
		
		for(int x = 0; x < cows; x++) {
			earliest = 100000001;
			
			for(int y = 0; y < cows; y++) {
				
				if(!processed[y] && enter[y] <=  earliest) {
					earliest = enter[y];
					index = y;
				}
			}
			
			if(earliest > times) {
				times = earliest + time[index];
			}
			else {
				times = times + time[index];
			}
			processed[index] = true;
		}
		
		pw.print(times);
		pw.close();
		
	}
}
