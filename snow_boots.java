import java.util.*;
import java.io.*;

public class snow_boots {
    static class SnowObj implements Comparable<SnowObj> {
        int idx;

        public SnowObj(int idx) {
            this.idx = idx;
        }

        public int compareTo(SnowObj a) {
            return snow[this.idx] - snow[a.idx];
        }
    }

    static class Obj implements Comparable<Obj> {
        int idx;

        public Obj(int idx) {
            this.idx = idx;
        }

        public int compareTo(Obj a) {
            return depth[this.idx] - depth[a.idx];
        }
    }

    static int N, B;
    static int[] depth = new int[100000];
    static int[] did = new int[100000];

    static int dcmp(int a, int b) {
        return depth[a] - depth[b];
    }

    static int[] snow = new int[100000];
    static int[] dist = new int[100000];
    static int[] ans = new int[100000];
    static int[] bid = new int[100000];

    public int s_bscmp(int a, int b) {
        return snow[a] - snow[b];
    }

    static int[] nxt = new int[100000];
    static int[] pre = new int[100000];

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Obj[] tempdid = new Obj[N];
        SnowObj[] tempbid = new SnowObj[B];

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < N; x++) {
            depth[x] = Integer.parseInt(st.nextToken());
            tempdid[x] = new Obj(x);
        }
        for (int x = 0; x < B; x++) {
            st = new StringTokenizer(br.readLine());
            snow[x] = Integer.parseInt(st.nextToken());
            dist[x] = Integer.parseInt(st.nextToken());
            tempbid[x] = new SnowObj(x);
        }
        br.close();
        Arrays.sort(tempbid);
        Arrays.sort(tempdid);

        for (int x = 0; x < N; x++) {
            did[x] = tempdid[x].idx;
        }
        for (int x = 0; x < B; x++) {
            bid[x] = tempbid[x].idx;
        }

        for (int x = 0; x < N; x++) {
            nxt[x] = x + 1;
            pre[x] = x - 1;
        }
        int j = N - 1;
        int maxStep = 1;

        for (int x = B - 1; x >= 0; x--) {
            int boot = bid[x];
            while (j >= 0 && depth[did[j]] > snow[boot]) {
                int cur = did[j];
                nxt[pre[cur]] = nxt[cur];
                pre[nxt[cur]] = pre[cur];
                maxStep = Math.max(maxStep, nxt[cur] - pre[cur]);
                j--;
            }
            ans[boot] = maxStep <= dist[boot] ? 1 : 0;
        }
        for (int x = 0; x < B; x++) {
            pw.println(ans[x]);
        }
        pw.close();
    }
}