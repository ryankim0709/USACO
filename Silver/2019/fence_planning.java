import java.util.*;
import java.io.*;

public class fence_planning {
    public static HashSet<Integer> inMooNetWork = new HashSet<>();
    public static HashSet<Integer> visited = new HashSet<>();

    public static class cow {
        int x;
        int y;

        public cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int pairs = Integer.parseInt(st.nextToken());

        cow[] cowLoc = new cow[cows];
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();

        for (int x = 0; x < cows; x++) {
            st = new StringTokenizer(br.readLine());
            cowLoc[x] = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            adjList.put(x, new HashSet<>());
        }

        int num1;
        int num2;
        for (int x = 0; x < pairs; x++) {
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken()) - 1;
            num2 = Integer.parseInt(st.nextToken()) - 1;
            adjList.get(num1).add(num2);
            adjList.get(num2).add(num1);
        }

        int ans = Integer.MAX_VALUE;
        for (int x = 0; x < cows; x++) {
            if (inMooNetWork.contains(x) == false) {
                visited = new HashSet<>();
                dfs(x, adjList);
                ans = Math.min(findMinPerim(cowLoc), ans);

                for (int y : visited) {
                    inMooNetWork.add(y);
                }
            }
        }
        pw.print(ans);
        pw.close();
        br.close();
    }

    public static void dfs(int start, HashMap<Integer, HashSet<Integer>> adjList) {
        if (visited.contains(start)) {
            return;
        }

        visited.add(start);
        for (int x : adjList.get(start)) {
            dfs(x, adjList);
        }
        return;
    }

    public static int findMinPerim(cow[] cowLoc) {
        int blx, bly, trx, trY;

        blx = Integer.MAX_VALUE;
        bly = Integer.MAX_VALUE;
        trx = Integer.MIN_VALUE;
        trY = Integer.MIN_VALUE;

        int x;
        int y;

        for (int a : visited) {
            x = cowLoc[a].x;
            y = cowLoc[a].y;

            if (x < blx) {
                blx = x;
            }
            if (y < bly) {
                bly = y;
            }
            if (x > trx) {
                trx = x;
            }
            if (y > trY) {
                trY = y;
            }
        }
        int len = trx - blx;
        int height = trY - bly;
        // System.out.println("blx: " + blx + " bly: " + bly + " trx: " + trx + " try: "
        // + trY + " len: " + len
        // + " height: " + height + " perim: " + (len + len + height + height));
        return len + len + height + height;
    }
}
