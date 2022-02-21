import java.util.*;
import java.io.*;

public class Mooyo_Mooyo {
    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /*
    Checking regions
        - Double for loop
        - Flood fill will return count
        - If count >= K
            - Flag = true
                - For continuing
            - Color the board for the coordinates as -1
    
    Gravity
        - For each column => Two pointer
            - Start one pointer at bottom
                - Keep looking up
                    - Hit number, then put down
                - At top, then fill with 0
            
    
    Checking if we should continue
        - Flag == True
            - Keep going
        - Else
            - Stop
     */

    static int[][] graph;
    static boolean[][] visited;
    static int count;
    static ArrayList<Coord> region = new ArrayList<>();

    static int N;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new int[N][10];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        br.close();

        boolean valid = true;

        while (valid) {
            valid = false;
            visited = new boolean[N][10];

            // Finding region and seeing if we should go onto next iteration
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 10; j++) {
                    if (graph[i][j] > 0 && !visited[i][j]) {
                        count = 0;
                        region = new ArrayList<>();
                        flood(graph[i][j], i, j);

                        if (count >= K) {
                            valid = true;
                            for (Coord k : region) {
                                graph[k.x][k.y] = 0;
                            }
                        }
                    }
                }
            }
            if (!valid) {
                break;
            }
            // Gravity
            for (int i = 0; i < 10; i++) { // Column
            // Two pointer
            int p1 = N - 1; // Bottom
            int p2 = N - 2; // Top

            while (p1 != 0) {
                if (p1 <= p2) {
                    p2 = p1 - 1;
                } else if (graph[p1][i] > 0) {
                    p1--;
                } else if (p2 <= 0) {
                    graph[p1][i] = graph[0][i];
                    graph[0][i] = 0;
                    p1--;
                } else if (graph[p2][i] > 0) { // Works!
                    graph[p1][i] = graph[p2][i];
                    graph[p2][i] = 0;
                    p1--;
                } else {
                    p2--;
                }
            }
        }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                pw.print(graph[i][j]);
            }
            pw.println();
        }
        pw.close();
    }
    
    public static void flood(int color, int x, int y) {
        if (x == -1 || x == N || y == -1 || y == 10 || visited[x][y] || graph[x][y] != color) {
            // Not valid or already visited
            return;
        }

        visited[x][y] = true;
        count++;
        region.add(new Coord(x, y));

        flood(color, x + 1, y);
        flood(color, x - 1, y);
        flood(color, x, y + 1);
        flood(color, x, y - 1);
    }
}
