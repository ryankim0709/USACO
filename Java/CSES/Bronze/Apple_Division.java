import java.io.*;
import java.util.*;

public class Apple_Division {
	static double min = Double.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int apples = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] apple = new int[apples];
		
		for(int x = 0; x < apples; x++) {
			apple[x] = Integer.parseInt(st.nextToken());
		}
		
		pset(apple, 0, new ArrayList<Integer>());
		System.out.println((int) min);
	}
	
	public static void pset(int[] apples, int idx, ArrayList<Integer> prefix) {
		int length = apples.length;
		if(idx == length) {
			double num = diff(apples, prefix);
			//System.out.println(num);
			min = Math.min(min, num);
			
		}
		
		else {
			
			idx ++;
				
			pset(apples, idx ,(ArrayList<Integer>) prefix.clone());
			
			prefix.add(idx-1);
			
			
			pset(apples, idx,(ArrayList<Integer>) prefix.clone());
		}
	}
	
	public static double diff(int[] apples, ArrayList<Integer> first) {
		
		double f = 0;
		double s = 0;
		//System.out.println(apples.length);
		for(int x = 0; x < apples.length; x++) {
			if(first.contains(x)) {
				f = f + apples[x];
			}
			else {
				s = s + apples[x];
			}
		}
		return Math.max(f, s) - Math.min(f, s);
	}
}
