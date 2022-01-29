import java.util.*;
import java.io.*;

public class switching_lights {
	// Pair class from official USACO solution
	static class Pair {
		public int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

	// Initial declarations
	static int N;
	static boolean illuminated[][];
	static boolean visited[][];
	static List<Pair>[][] switches;
	static int litRooms = 1;

	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {-1, 0, 1, 0};

	// Checks if a room is connected to the main component
	public static boolean checkConnected(int x, int y) {
		// Iterate through neighbors
		for (int i = 0; i < 4; i++) {
			int newX = x + dirX[i];
			int newY = y + dirY[i];

			//Ignore neighbor if out of bounds
			if (newX < 0 || newY < 0 || newX > N - 1 || newY > N - 1) {
				continue;
			}

			// If a neighbor is visited, the room is connected to the main 
			// component, return true
			if (visited[newX][newY]) {
				return true;
			}
		}

		// If no neighbors have been visited, return false
		return false;
	}

	// Floodfill method with source room (x, y)
	public static void floodfill(int x, int y) {
		// Ignore this room if its out of bounds, already visited, or isn't lit
		if (x < 0 || y < 0 || x > N - 1 || y > N - 1 || visited[x][y] || !illuminated[x][y]) {
			return;
		}

		/* 
		 * Ignore room if it isn't connected to main component 
		 * (i.e. it's inaccessible to Bessie)
		 * Don't return on coordinate (1, 1)
		 */
		if (!checkConnected(x, y) && !(x == 0 && y == 0)) {
			return;
		}

		// Set room to visited
		visited[x][y] = true;

		// Iterate through neighbors and floodfill from them
		for (int i = 0; i < 4; i++) {
			floodfill(x + dirX[i], y + dirY[i]);
		}

		// Turn on all lights from current room
		for (int i = 0; i < switches[x][y].size(); i++) {
			int roomX = switches[x][y].get(i).x;
			int roomY = switches[x][y].get(i).y;

			/* 
			 * If room hasn't been lit yet, add it to our count of rooms that 
			 * have been lit
			 */
			if (!illuminated[roomX][roomY]) {
				litRooms++;
			}

			// Set room led to by switch to lit
			illuminated[roomX][roomY] = true;

			// Floodfill from new room that is lit
			floodfill(roomX, roomY);
		}

	}

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader in = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		illuminated = new boolean[N][N];
		visited = new boolean[N][N];
		switches = new ArrayList[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switches[i][j] = new ArrayList<Pair>();
			}
		}

		// Take in input and add switches to corresponding room
		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());

			switches[x - 1][y - 1].add(new Pair(a - 1, b - 1));
		}

		// Set the top left room to lit (since it's lit initially)
		illuminated[0][0] = true;

		// Start floodfill from top-left room
		floodfill(0, 0);

		out.println(litRooms);
		out.close();
	}
}