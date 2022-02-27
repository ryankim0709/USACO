import java.util.*;
import java.io.*;

public class Tree_Diameter_Double_DFS {
    static HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();

    static int maxSteps = 0;
    static int maxStepNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.putIfAbsent(x, new HashSet<>());
            tree.get(x).add(y);

            tree.putIfAbsent(y, new HashSet<>());
            tree.get(y).add(x);
        }

        dfsteps(1, 0, 0);
        dfsteps(maxStepNum, 0, 0);
        System.out.println(maxSteps);
    }
    
    public static void dfsteps(int current, int steps, int prev) {
        if (steps > maxSteps) {
            maxStepNum = current;
            maxSteps = steps;
        }

        tree.putIfAbsent(current, new HashSet<>());
        for (int i : tree.get(current)) {
            if (i != prev) {
                dfsteps(i, steps + 1, current);
            }
        }
    }
}
