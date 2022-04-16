import java.util.*;
import java.io.*;
public class forestQueries {
	public static void main(String[] args) throws IOException{
		//Given N and M which are row and column
		//Given the 2D array, be able to query through them
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		String a;
		for(int x = 0; x < N; x++) {
			a = br.readLine();
			for(int y = 0; y < N; y++) {
				if(a.charAt(y) == '*') {
					arr[x][y] = 1;
				}
				else {
					arr[x][y] = 0;
				}
			}
		}
		
		int[][] prefix = new int[N+1][N+1];
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				prefix[x][y] = prefix[x-1][y] + prefix[x][y-1] - prefix[x-1][y-1] + arr[x-1][y-1];
			}
		}
		
		for(int x = 0; x < Q; x++) {
			System.out.println(x);
			br.readLine().toString();
			//System.out.println(br.readLine().toString());
			//System.out.println(query(prefix, arr, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
	}
	
	public static int query(int[][] prefix, int[][] arr, int x1, int y1, int x2, int y2) {
		//limitation is that when we call x1 and x2 as 0,0, program will fail
		return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1]+prefix[x1-1][y1-1];
	}
}
