import java.util.*;
import java.io.*;

public class journey {
    public static Map<Integer, ArrayList<Integer>> adlist = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();
    public static float leaves = 0;
    public static float sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(br.readLine());
        for (int x = 1; x <= cities; x++) {
            adlist.put(x, new ArrayList<Integer>());
        }

        StringTokenizer st;
        int start;
        int end;

        for (int x = 0; x < cities - 1; x++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            adlist.get(start).add(end);
            adlist.get(end).add(start);
        }
        // visited.add(1);
        dfs(-1, 1);

        float ans = sum / leaves;
        System.out.println(ans);
        // System.out.println("Sum: " + sum + " leaves: " + leaves);
    }

    public static void dfs(int len, int current) {
        int thing = len + 1;
        if (adlist.get(current).size() == 1 && current != 1) {
            sum += thing;
            leaves++;
            return;
        }

        visited.add(current);

        for (int path : adlist.get(current)) {
            if (visited.contains(path)) {
                continue;
            }
            dfs(thing, path);
        }
        visited.remove(current);
    }
}
