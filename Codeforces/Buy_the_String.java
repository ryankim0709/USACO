import java.util.*;
import java.io.*;

public class Buy_the_String {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int strings = Integer.parseInt(br.readLine());
		int length,c0,c1,swap;
		System.out.println();
		for(int x = 0; x < strings; x++) {
			st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			c0 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			swap = Integer.parseInt(st.nextToken());
			System.out.println(value(length,c0,c1,swap,br.readLine()));
		}
	}
	
	public static int value(int length, int c0, int c1, int swap, String string) {
		int noChange = 0;
		int cheapCost = Math.min(c0, c1);
		int cheapCount = 0;
		char cheap;
		
		if(c0 == cheapCost) {
			cheap = '0';
		}
		else {
			cheap = '1';
		}
		for(int x = 0; x < length; x++) {
			
			if(string.charAt(x) == '0') {
				noChange += c0;
				if(cheap == '0') {
					cheapCount ++;
				}
			}
			
			else {
				noChange += c1;
				if(cheap == '1') {
					cheapCount ++;
				}
			}
		}
		int alternative = swap*(length-cheapCount) + length*cheapCost;
		
		return Math.min(noChange, alternative);
	}
}
