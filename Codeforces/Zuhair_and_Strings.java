import java.util.*;
import java.io.*;

public class Zuhair_and_Strings {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		String sub;
		HashMap<Character,Integer> occurence = new HashMap<>();
		
		for(int x = 0; x < n - k + 1; x++) {
			//System.out.println(x);
			//System.out.println(x);
			sub = s.substring(x,x + k);
			if(check(sub)) {
				x = x + k - 1;
				if(occurence.keySet().contains(sub.charAt(0))) {
				
					occurence.put(sub.charAt(0), occurence.get(sub.charAt(0)) + 1);
				}
				else {
					occurence.put(sub.charAt(0),1);
				}
			}
		}
		int max = 0;
		for(int x:occurence.values()) {
			if(x > max) {
				max = x;
			}
		}
		//System.out.println(occurence);
		System.out.println(max);
	}
	
	public static boolean check(String a) {
		char b = a.charAt(0);
		
		for(int x = 1; x < a.length(); x++) {
			if(a.charAt(x) != b) {
				return false;
			}
		}
		return true;
	}
}
