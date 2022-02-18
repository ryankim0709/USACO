import java.io.*;

public class Build_Gates {
    static boolean[][] graph = new boolean[5001][5001];
    static boolean[][] visited = new boolean[5001][5001];
    static int minx = 6000;
    static int miny = 6000;
    static int maxx = -1;
    static int maxy = -1;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));

        int N = Integer.parseInt(br.readLine());
        String commands = br.readLine();

        int x = 2500;
        int y = 2500;

        for (int i = 0; i < N; i++) {
            char dir = commands.charAt(i);
            graph[x][y] = true;
            if (dir == 'N') {
                y++;
                graph[x][y] = true;
                y++;
            } else if (dir == 'S') {
                y--;
                graph[x][y] = true;
                y--;
            } else if (dir == 'E') {
                x++;
                graph[x][y] = true;
                x++;
            } else {
                x--;
                graph[x][y] = true;
                x--;
            }
            br.close();
            graph[x][y] = true;

            minx = Math.min(minx, x);
            miny = Math.min(miny, y);
            maxx = Math.max(maxx, x);
            maxy = Math.max(maxy, y);
        }
        minx = Math.max(0, minx - 1);
        miny = Math.max(0, miny - 1);
        maxx = Math.min(5000, maxx + 1);
        maxy = Math.min(5000, maxy + 1);
        // System.out.println(flood_fill() - 1);
        pw.println(flood_fill() - 1);
        pw.close();
    }

    public static int flood_fill() {
        int regions = 0;

        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <= maxy; j++) {
                if (graph[i][j] == false) {
                    // for (int k = minx; k <= maxx; k++) {
                    //     System.out.println();
                    //     for (int l = miny; l <= maxy; l++) {
                    //         System.out.print((graph[k][l] ? 1 : 0)+ " ");
                    //     }
                    // }
                    //System.out.println();
                    dfs(i, j);
                    regions++;
                }
            }
        }
        return regions;
    }
    
    public static void dfs(int x, int y) {
        //System.out.println(x + " " + y);
        if (x == minx - 1 || x == maxx + 1 || y == miny - 1 || y == maxy + 1 || graph[x][y]) {
            return;
        }
        graph[x][y] = true;
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}