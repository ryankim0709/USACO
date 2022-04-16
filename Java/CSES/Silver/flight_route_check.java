import java.util.*;
import java.io.*;

public class flight_route_check {
    public static HashMap<Integer, HashSet<Integer>> adj1 = new HashMap<>();
    public static HashMap<Integer, HashSet<Integer>> adj2 = new HashMap<>();

    public static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(st.nextToken());
        int flights = Integer.parseInt(st.nextToken());

        int start, end;

        for (int x = 0; x < flights; x++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            if (!adj1.containsKey(start)) {
                adj1.put(start, new HashSet<>());
            }

            if (!adj2.containsKey(end)) {
                adj2.put(end, new HashSet<>());
            }

            adj1.get(start).add(end);
            adj2.get(end).add(start);
        }

        dfs1(1);
        if (visited.size() == cities) {
            visited = new HashSet<>();

            dfs2(1);

            if (visited.size() == cities) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
                for (int x = 1; x <= cities; x++) {
                    if (visited.contains(x) == false) {
                        System.out.println(x + " " + "1");
                    }
                }
            }
        } else {
            System.out.println("NO");
            for (int x = 1; x <= cities; x++) {
                if (visited.contains(x) == false) {
                    System.out.println("1" + " " + x);
                }
            }
        }
    }

    public static void dfs1(int current) {
        if (visited.contains(current)) {
            return;
        }

        visited.add(current);

        if (adj1.containsKey(current)) {
            adj1.put(current, new HashSet<>());
        }

        for (int x : adj1.get(current)) {
            dfs1(x);
        }
    }

    public static void dfs2(int current) {
        if (visited.contains(current)) {
            return;
        }

        visited.add(current);

        if (adj2.containsKey(current)) {
            adj2.put(current, new HashSet<>());
        }

        for (int x : adj2.get(current)) {
            dfs1(x);
        }
    }
}