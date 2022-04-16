import java.util.*;
import java.io.*;

public class Stuck_In_A_Rut {
	
	static class cow implements Comparable<cow> {
		private int x;
		private int y;
		private char direction;
		
		public cow(char direction, int x, int y) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
		
		public int compareTo(cow second) {
			if(direction == 'E') {
				if(y < second.y) {
					return -1;
				}
				if(second.y < y) {
					return 1;
				}
				return 0;
			}
			else {
				if(x < second.x) {
					return -1;
				}
				if(second.x < x) {
					return 1;
				}
				return 0;
			}
		}
		
		public String toString() {
			return direction+" "+x+" "+y;
		}
	}
	
	public static void main(String args[]) throws IOException{
		/* Slowest time: 197 ms
		 * Time Complexity: O(n^2)
		 * Basic function: Once we put our cow objects into our data structures, we want to check when each cow will 
		 * intersect. We strictly start from bottom up for east and left right for right because we want to find the first
		 * intersection
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		
		int cows = Integer.parseInt(br.readLine());//number of cows
		
		HashMap<cow, Boolean> collided = new HashMap<>();//HashMap to see if the cows collided
		HashMap<cow,String> distance = new HashMap<>();//HashMap to see distance
		
		ArrayList<cow> east = new ArrayList<>();//cows traveling east
		ArrayList<cow> north = new ArrayList<>();//cows traveling north
		
		cow[] order = new cow[cows];//HashMap won't preserve order, so we need a cow array to do this
		
		cow command = new cow('E',0,0);
		int eastCow = 0;
		int northCow = 0;
		
		for(int x = 0; x < cows; x++) {//scanning
			st = new StringTokenizer(br.readLine());
			command = new cow(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if(command.direction == 'E') {
				east.add(command);
				eastCow ++;
			}
			
			else {
				north.add(command);
				northCow ++;
			}
			
			collided.put(command, false);
			order[x] = command;
			distance.put(command, "0");
		}
		Collections.sort(east);
		Collections.sort(north);
		
		int eDistance = 0;
		int nDistance = 0;
		
		cow northC = null;
		cow eastC = null;
		
		for(int x = 0; x < northCow; x++) {//for each north facing cow from left to right
			northC = north.get(x);
			for(int y = 0; y < eastCow; y++) {//for each east facing cow
				eastC = east.get(y);
				
				if(!collided.get(eastC) && northC.x > eastC.x && northC.y < eastC.y) {//if the two cows will collide
					
					eDistance = northC.x - eastC.x;//distance east cow travels
					nDistance = eastC.y - northC.y;//distance north cow travels
					
					if(eDistance == nDistance) {
						//if they are the same, that means both cows land on the intersections at the same time, thus they share.
						continue;
					}
					else if(nDistance > eDistance) {
						//if the east cow gets to the intersections first, the north cow stops, we add information to our data structure
						distance.put(northC, String.valueOf(nDistance));
						collided.put(northC, true);
						break;
					}
					else if(eDistance > nDistance) {
						//if the north cow gets to the intersection first, the east cow stops, we add information to our data structure
						distance.put(eastC, String.valueOf(eDistance));
						collided.put(eastC, true);
					}
				}
				else if(y == eastCow - 1) {//if a north cow reaches this point, there is not cow that blocks them, thus they travel "Infinity"
					distance.put(northC, "Infinity");
				}
			}
		}
		
		for(int x = 0; x < eastCow; x++) {//for each east cow
			eastC = east.get(x);
			if(collided.get(eastC)) {//check if that cow has not collided
				continue;
			}
			for(int y = 0; y < northCow; y++) {//for each north cow
				northC = north.get(y);
				
				if(!collided.get(northC) && northC.x > eastC.x && northC.y < eastC.y) {//check if they collide
					//do the same thing as above
					eDistance = northC.x - eastC.x;
					nDistance = eastC.y - northC.y;
					
					if(eDistance == nDistance) {
						continue;
					}
					else if(nDistance > eDistance) {
						distance.put(northC, String.valueOf(nDistance));
						collided.put(northC, true);
					}
					else if(eDistance > nDistance) {
						distance.put(eastC, String.valueOf(eDistance));
						collided.put(eastC, true);
						break;
					}
				}
				else if(y == northCow - 1) {
					distance.put(eastC, "Infinity");
				}
			}
		}
		
		for(cow x:order) {//using our cow array to keep order
			if(distance.get(x).equals("0")) {//our code may output 0, meaning there are no cows blocking the path, thus we print "Infinity"
				System.out.println("Infinity");
			}
			else {//otherwise, print whats in the HashMap
				System.out.println(distance.get(x));
			}
		}
		
	}
}
