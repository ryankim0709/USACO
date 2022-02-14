import java.util.*;
import java.io.*;

public class milk_pails {
    static boolean[][][] visited = new boolean[105][105][105];
    // Block will be K
    // X and Y is row and column
    static int X, Y, K, M;

    static int ans = 205;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.close();
        
        dfs(0, 0, 0);
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
    }

    public static void dfs(int x, int y, int k) {

        // Terminal condition
        if (visited[k][x][y] || k > K) {
            return;
        }

        visited[k][x][y] = true;
        ans = Math.min(ans, Math.abs(x + y - M));

        // Fill A
        dfs(X, y, k + 1);

        // Fill B
        dfs(x, Y, k + 1);

        // Pour A
        dfs(0, y, k + 1);

        // Pour B
        dfs(x, 0, k + 1);

        // A into B
        if (Y - y >= x) { // Can fill put everything into B
            dfs(0, y + x, k + 1);
        } else { // Will have leftover in A
            dfs(x - (Y - y), Y, k + 1);
        }

        // B into A
        if (X - x >= y) { // Can put everythin from B into A
            dfs(x + y, 0, k + 1);
        } else { // Will be leftover
            dfs(X, y - (X - x), k + 1);
        }
    }
}