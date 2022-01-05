import java.util.*;
import java.io.*;

public class mootube {
    public static HashMap<Integer, HashSet<int[]>> adjList = new HashMap<>();
    public static boolean[] visited;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int questions = Integer.parseInt(st.nextToken());

        for (int x = 1; x <= cows; x++) {
            adjList.put(x, new HashSet<>());
        }

        int val1;
        int val2;
        int rel;
        int[] arr = new int[2];

        for (int x = 0; x < cows - 1; x++) {
            st = new StringTokenizer(br.readLine());
            val1 = Integer.parseInt(st.nextToken());
            val2 = Integer.parseInt(st.nextToken());
            rel = Integer.parseInt(st.nextToken());
            arr[0] = val2;
            arr[1] = rel;
            adjList.get(val1).add(arr.clone());
            arr[0] = val1;
            adjList.get(val2).add(arr.clone());
        }

        int start;
        int k;
        for (int x = 0; x < questions; x++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            visited = new boolean[cows];
            ans = 0;

            visited[start - 1] = true;

            for (int[] a : adjList.get(start)) {
                dfs(a[0], k, a[1]);
            }
            pw.println(ans);
        }
        pw.close();
        br.close();
    }

    public static void dfs(int current, int k, int currRel) {

        visited[current - 1] = true;
        if (currRel >= k) {
            ans++;
        }
        if (currRel < k) {
            return;
        }
        for (int[] a : adjList.get(current)) {
            if (!visited[a[0] - 1]) {
                dfs(a[0], k, Math.min(a[1], currRel));
            }
        }
    }
}
