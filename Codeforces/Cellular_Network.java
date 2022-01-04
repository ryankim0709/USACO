import java.util.*;
import java.io.*;
public class Cellular_Network {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cities = Integer.parseInt(st.nextToken());
		int towers = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> cityLoc = new TreeSet<>();
		TreeSet<Integer> towerLoc = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int x = 0; x < cities; x++) {
			cityLoc.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int x = 0; x < towers; x++) {
			towerLoc.add(Integer.parseInt(st.nextToken()));
		}
		towerLoc.add(Integer.MAX_VALUE);
		towerLoc.add(Integer.MIN_VALUE);
		
		int ans = Integer.MIN_VALUE;
		int right;
		int left;
		int closer;
		//System.out.println(cityLoc);
		//System.out.println(towerLoc);
		for(int x:cityLoc) {
			right = towerLoc.ceiling(x);
			left = towerLoc.floor(x);
			right = right - x;
			left = x - left;
			//System.out.println("Right distance: "+right+" left distance: "+left);
			closer = Math.min(left, right);
			if(closer > ans) {
				ans = closer;
			}
		}
		System.out.println(ans);
	}
}
