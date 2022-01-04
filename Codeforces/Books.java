import java.util.*;
import java.io.*;
public class Books {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int books = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		int[] timeReq = new int[books+1];
		timeReq[0] = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int x = 1; x < books + 1; x++) {
			timeReq[x] = timeReq[x-1] + Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = books;
		int ans = 0;
		
		while(right >= 1) {
			if(left > right) {
				left = 1;
				right = right - 1;
			}
			else if(timeReq[right] - timeReq[left-1] <= time) {
				ans = Math.max(right - left + 1, ans);
				left ++;
			}
			
			else {
				left ++;
			}
			
		}
		System.out.println(ans);
	}
}
