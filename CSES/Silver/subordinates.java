import java.util.*;
import java.io.*;
public class subordinates {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int employees = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> pyramid = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int x = 2; x <= employees; x++) {
			pyramid.put(x, Integer.parseInt(st.nextToken()));
		}
		
		int[] ans = new int[employees];
		int y;
		for(int x:pyramid.keySet()) {
			y = x;
			
			while(y != 1) {
				ans[pyramid.get(y) - 1] ++;
				y = pyramid.get(y);
			}
		}
		for(int x:ans) {
			System.out.print(x+" ");
		}
	}
}
