import java.util.*;
import java.io.*;
public class Angry_Cows {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int bales = Integer.parseInt(st.nextToken());
		int cows = Integer.parseInt(st.nextToken());
		
		int[] baleloc = new int[bales];
		
		for(int x = 0; x < bales; x++) {
			baleloc[x] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(baleloc);
		
		int low = 0;
		int high = baleloc[bales - 1] - baleloc[0];
		int r;
		
		while(low < high) {
			r = low + (high - low)/2;
			if(tryR(baleloc, r, cows)) {
				high = r;
			}
			else {
				low = r + 1;
			}
		}
		pw.print(low);
		pw.close();
	}
	
	public static boolean tryR(int[] baleloc, int r, int cows) {
		int left = baleloc[0];
		r = r * 2;
		
		for(int right: baleloc) {
			if(right - left > r) {
				cows --;
				left = right;
			}
			if(cows <= 0) {
				return false;
			}
		}
		return true;
	}
}