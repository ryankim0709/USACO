import java.util.*;
import java.io.*;
public class prefix2D {
	public static void main(String[] args) throws IOException{
		//Given N and M which are row and column
		//Given the 2D array, be able to query through them
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < M; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int[] x:arr) {
			System.out.println();
			for(int y:x) {
				System.out.print(y+" ");
			}
		}
		
		int[][] prefix = new int[N+1][M+1];
		
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= M; y++) {
				prefix[x][y] = prefix[x-1][y] + prefix[x][y-1] - prefix[x-1][y-1] + arr[x-1][y-1];
			}
		}
		System.out.println();
		for(int[] x:prefix) {
			System.out.println();
			for(int y:x) {
				System.out.print(y+" ");
			}
		}
		System.out.println();
		System.out.println(prefix[0][1]);
		System.out.println(prefix[1][0]);
		System.out.println(prefix[0][0]);
		System.out.println(prefix[1][1]);
		
		System.out.println("QUERRY: "+query0(prefix, arr, 1,1));
		System.out.println("QUERRY: "+query(prefix, arr, 2,2,3,4));
	}
	
	public static int query0(int[][] prefix, int[][] arr,  int x, int y) {
		return prefix[x-1][y] + prefix[x][y-1] - prefix[x-1][y-1] + arr[x][y];
	}
	
	public static int query(int[][] prefix, int[][] arr, int x1, int y1, int x2, int y2) {
		//limitation is that when we call x1 and x2 as 0,0, program will fail
		return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1]+prefix[x1-1][y1-1];
	}
}
