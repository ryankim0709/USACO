import java.util.*;
import java.io.*;
public class CountingRooms {
	public static char[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		
		graph = new char[rows][columns];
		
		for(int x = 0; x < rows; x++) {
			graph[x] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				if(graph[x][y] == '.') {
					dfs(x, y);
					ans ++;
				}
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int x, int y) {
		if(!valid(x,y) || graph[x][y] == '#') {
			return;
		}
		graph[x][y] = '#';
		
		dfs(x+1, y);
		dfs(x-1, y);
		dfs(x,y+1);
		dfs(x,y-1);
	}
	public static boolean valid(int x, int y ) {
		
		return(x >= 0 && x < graph.length && y >= 0 && y < graph[0].length);
	}
}
