import java.util.*;
import java.io.*;
public class Array_Division {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numElements = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] elements = new int[numElements];
		int max = 0;
		st = new StringTokenizer(br.readLine());

		for(int x = 0; x < numElements; x++) {
			elements[x] = Integer.parseInt(st.nextToken());
			max += elements[x];
		}
		
		int low = 0;
		int high = max;
		int mid;
		
		while(low < high) {
			mid = low + (high - low)/2;
			
			if(verify(k, elements, mid)) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		System.out.println(low);
	}
	
	public static boolean verify(int k, int[] elements, int max) {
		int sum = 0;
		for(int right:elements) {
			sum += right;
			
			if( sum > max) {
				k--;
				sum = right;
			}
			
			if(k <= 0) {
				return false;
			}
		}
		return true;
	}
}
