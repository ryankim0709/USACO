import java.util.*;
import java.io.*;

public class splitting_field {

    static class cow implements Comparable<cow> {
        long x, y;

        public cow(Long x, Long y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(cow a) {
            long ans = this.x - a.x;
            if (ans > 0) {
                return 1;
            } else if (ans == 0) {
                long ans2 = this.y - a.y;

                if (ans2 > 0) {
                    return 1;
                }
                return -1;
            }
            return -1;
        }
    }

    static class cowy implements Comparable<cowy> {
        long x, y;

        public cowy(Long x, Long y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(cowy a) {
            long ans = this.y - a.y;
            if (ans > 0) {
                return 1;
            } else if (ans == 0) {
                long ans2 = this.x - a.x;

                if (ans2 > 0) {
                    return 1;
                }
                return -1;
            }
            return -1;
        }
    }

    static TreeMap<Long, Integer> rec1x = new TreeMap<>();
    static TreeMap<Long, Integer> rec1y = new TreeMap<>();
    static TreeMap<Long, Integer> rec2x = new TreeMap<>();
    static TreeMap<Long, Integer> rec2y = new TreeMap<>();
    static int numCows;

    static TreeMap<Long, Integer> rec1xy = new TreeMap<>();
    static TreeMap<Long, Integer> rec1yy = new TreeMap<>();
    static TreeMap<Long, Integer> rec2xy = new TreeMap<>();
    static TreeMap<Long, Integer> rec2yy = new TreeMap<>();

    static cow[] cows;
    static cowy[] cows2;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/ryan/Desktop/mountains_silver_jan19/4.in"));
        // BufferedReader br = new BufferedReader(new FileReader("split.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));
        numCows = Integer.parseInt(br.readLine());
        StringTokenizer st;

        cows = new cow[numCows];
        cows2 = new cowy[numCows];

        for (int x = 0; x < numCows; x++) {
            st = new StringTokenizer(br.readLine());
            cows[x] = new cow(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            cows2[x] = new cowy(cows[x].x, cows[x].y);

            if (!rec2x.containsKey(cows[x].x)) {
                rec2x.put(cows[x].x, 0);
            }
            if (!rec2y.containsKey(cows[x].y)) {
                rec2y.put(cows[x].y, 0);
            }
            rec2x.put(cows[x].x, rec2x.get(cows[x].x) + 1);
            rec2y.put(cows[x].y, rec2y.get(cows[x].y) + 1);

            if (!rec2xy.containsKey(cows[x].x)) {
                rec2xy.put(cows[x].x, 0);
            }
            if (!rec2yy.containsKey(cows[x].y)) {
                rec2yy.put(cows[x].y, 0);
            }
            rec2xy.put(cows[x].x, rec2xy.get(cows[x].x) + 1);
            rec2yy.put(cows[x].y, rec2yy.get(cows[x].y) + 1);
        }
        br.close();
        long masterArr = (rec2x.lastKey() - rec2x.firstKey()) * (rec2y.lastKey() - rec2y.firstKey());
        Arrays.sort(cows);
        Arrays.sort(cows2);

        long remove = Long.MAX_VALUE;
        remove = Math.min(remove, simulate());
        remove = Math.min(remove, simulate1());

        System.out.println(masterArr - remove);
        System.out.println(masterArr + " " + remove);
        pw.println(masterArr - remove);
        pw.close();
    }

    public static long simulate() {
        long xcoord;
        long ycoord;

        long ar1, ar2;

        Long ans = Long.MAX_VALUE;
        for (int x = 0; x < numCows - 1; x++) {
            cow a = cows[x];
            xcoord = a.x;
            ycoord = a.y;

            if (!rec1x.containsKey(xcoord)) {
                rec1x.put(xcoord, 0);
            }
            if (!rec1y.containsKey(ycoord)) {
                rec1y.put(ycoord, 0);
            }

            rec1x.put(xcoord, rec1x.get(xcoord) + 1);
            rec1y.put(ycoord, rec1y.get(ycoord) + 1);
            rec2x.put(xcoord, rec2x.get(xcoord) - 1);
            rec2y.put(ycoord, rec2y.get(ycoord) - 1);

            if (rec2x.get(xcoord) == 0) {
                rec2x.remove(xcoord);
            }
            if (rec2y.get(ycoord) == 0) {
                rec2y.remove(ycoord);
            }

            ar1 = (rec1x.lastKey() - rec1x.firstKey()) * (rec1y.lastKey() - rec1y.firstKey());

            ar2 = (rec2x.lastKey() - rec2x.firstKey()) * (rec2y.lastKey() - rec2y.firstKey());

            ans = Math.min(ans, (ar1 + ar2));
        }
        return ans;
    }

    public static long simulate1() {
        long xcoord;
        long ycoord;

        long ar1, ar2;

        Long ans = Long.MAX_VALUE;
        for (int x = 0; x < numCows - 1; x++) {
            cowy a = cows2[x];
            xcoord = a.x;
            ycoord = a.y;

            if (!rec1xy.containsKey(xcoord)) {
                rec1xy.put(xcoord, 0);
            }
            if (!rec1yy.containsKey(ycoord)) {
                rec1yy.put(ycoord, 0);
            }

            rec1xy.put(xcoord, rec1xy.get(xcoord) + 1);
            rec1yy.put(ycoord, rec1yy.get(ycoord) + 1);
            rec2xy.put(xcoord, rec2xy.get(xcoord) - 1);
            rec2yy.put(ycoord, rec2yy.get(ycoord) - 1);

            if (rec2xy.get(xcoord) == 0) {
                rec2xy.remove(xcoord);
            }
            if (rec2yy.get(ycoord) == 0) {
                rec2yy.remove(ycoord);
            }

            ar1 = (rec1xy.lastKey() - rec1xy.firstKey()) * (rec1yy.lastKey() - rec1yy.firstKey());

            ar2 = (rec2xy.lastKey() - rec2xy.firstKey()) * (rec2yy.lastKey() - rec2yy.firstKey());

            ans = Math.min(ans, (ar1 + ar2));
        }
        return ans;
    }
}