import java.util.*;
import java.io.*;

public class lifeguards2 {
    public static class point implements Comparable<point> {
        int index;
        char type;
        int time;

        public point(int index, char type, int time) {
            this.index = index;
            this.type = type;
            this.time = time;
        }

        public int compareTo(point a) {
            return this.time - a.time;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int guards = Integer.parseInt(st.nextToken());

        point[] points = new point[guards * 2];

        for (int x = 0; x < guards; x++) {
            st = new StringTokenizer(br.readLine());
            points[2 * x] = new point(x, 's', Integer.parseInt(st.nextToken()));
            points[2 * x + 1] = new point(x, 'e', Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(points);
        System.out.println();

        int totalTime = 0;
        int last = 0;
        int[] aloneTimes = new int[guards];
        TreeSet<Integer> atOnce = new TreeSet<Integer>();
        for (point a : points) {
            if (atOnce.size() == 1) {
                aloneTimes[atOnce.first()] += a.time - last;
            }
            if (atOnce.size() > 0) {
                totalTime += a.time - last;
            }
            if (a.type == 'e') {
                // System.out.println(atOnce);
                atOnce.remove(a.index);
                // System.out.println(atOnce + "\n");

            } else {
                atOnce.add(a.index);
            }
            last = a.time;
        }

        int minAlone = Integer.MAX_VALUE;
        for (int x : aloneTimes) {
            // System.out.println(x);
            minAlone = Math.min(minAlone, x);
        }
        // System.out.println(totalTime - minAlone);
        pw.print(totalTime - minAlone);
        pw.close();
        br.close();
    }
}
