import java.util.*;
import java.io.*;

public class Balancing {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		int cows = Integer.parseInt(br.readLine());
		
		int[] x_coordinates = new int[cows];
		int[] y_coordinates = new int[cows];
		
		StringTokenizer st = null;
		
		for(int x = 0; x < cows;x++) {
			st = new StringTokenizer(br.readLine());
			
			x_coordinates[x] = Integer.parseInt(st.nextToken());
			y_coordinates[x] = Integer.parseInt(st.nextToken());
			
			
		}
		
		int min = cows;
		int xline = 0;
		int yline = 0;
		int x_point = 0;
		int y_point = 0;
		
		int quad1 = 0;
		int quad2 = 0;
		int quad3 = 0;
		int quad4 = 0;
		int maxx = 0;
		
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for(int x:x_coordinates) {
			xline = x+1;
			
			left.clear();
			right.clear();
			
			for(int a = 0; a < cows; a++) {
				if(x_coordinates[a] < xline) {
					left.add(a);
				}
				
				else {
					right.add(a);
				}
			}
			
			
			for(int y:y_coordinates) {
				yline = y + 1;
				quad1 = 0;
				quad2 = 0;
				quad3 = 0;
				quad4 = 0;
				
				for(int z:left) {
					if(y_coordinates[z] > yline) {
						quad2 ++;
					}
					
					else {
						quad3++;
					}
				}
				
				for(int z:right) {
					if(y_coordinates[z] > yline) {
						quad1++;
					}
					else {
						quad4++;
					}
				}
				
				maxx = Math.max(Math.max(quad1, quad2), Math.max(quad3, quad4));
				
				if(maxx < min) {
					min = maxx;
				}
			}
		}
		
		pw.print(min);
		//System.out.println(min);
		pw.close();
	}
}