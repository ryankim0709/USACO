import java.util.*;
import java.io.*;
	
public class Milk_Factory {
	static ArrayList<Boolean> validity = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		/*Slowest time: 274 ms
		 *Basic function: We scan using BufferedReader, then we just brute force the problem.
		 *We test if every factory y can get to factory x. To do this, we use a recursive function
		 *to figure out if there is a path. We add true of false into our global ArrayList
		 *then check back in our main function.
		 */
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
		StringTokenizer st;
		
		int factories = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] paths = new ArrayList[factories+1];
		int from = 0;
		int to = 0;
			
		for(int x = 1; x < factories + 1; x++) {
			paths[x] = new ArrayList<Integer>();
		}
			
		for(int x = 0; x < factories-1; x++) {
			st = new StringTokenizer(br.readLine());
				
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			paths[from].add(to);
		}
		
		for(int x = 1; x < factories + 1; x++) {
			validity.clear();
			for(int y = 1; y < factories + 1; y ++) {
				if(y == x) {
					continue;
				}
				
				else {
					if(y == factories) {
						if(validity.contains(false)) {
							continue;
						}
						else {
							pw.print(x);
							pw.close();
							br.close();
						}
					}
					
					else {
						has_path(paths,y,x);
					}
				}
			}
		}
		pw.print(-1);
		pw.close();
		br.close();
	}
	
	public static void has_path(ArrayList<Integer>[] paths, int at, int goal) {
		ArrayList<Integer> clone = paths[at];
	
		if(clone.contains(goal)) {
			validity.add(true);
		}
		
		else if(clone.size() == 0) {
			validity.add(false);
		}
		
		else {
			for(int x:clone) {
				has_path(paths, x,goal);
			}
		}
	}
}