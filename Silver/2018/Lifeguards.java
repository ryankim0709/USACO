import java.util.*;
import java.io.*;

public class Lifeguards {

    public static class lifeguard implements Comparable<lifeguard> {
        int start;
        int end;

        public lifeguard(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(lifeguard a) {
            if (this.start < a.start) {
                return -1;
            }

            if (this.end < a.end) {
                return -1;
            }

            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        BufferedReader br = new BufferedReader(new FileReader("/Users/ryan/Desktop/lifeguards_silver_jan18/2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int guards = Integer.parseInt(st.nextToken());
        lifeguard[] guardTimes = new lifeguard[guards];

        if (guards == 1) { // If there is one guard, and one guard is removed, then there is no guard, thus
                           // 0 time covered
            System.out.println(0);
            pw.print(0);
            pw.close();
            br.close();
        }

        else {
            for (int x = 0; x < guards; x++) {
                st = new StringTokenizer(br.readLine());
                guardTimes[x] = new lifeguard(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(guardTimes);

            // for (lifeguard a : guardTimes) {
            // System.out.println(a.start + " " + a.end);
            // }
            int minTimeAlone = Integer.MAX_VALUE;

            for (int x = 0; x < guards; x++) {
                minTimeAlone = Math.min(minTimeAlone, aloneTime(x, guardTimes));
                // System.out.println("Cow: " + x + " Time Alone: " + aloneTime(x, guardTimes));
            }
            System.out.println(guardTimes[guardTimes.length - 1].end - guardTimes[0].start - minTimeAlone);
            pw.print(guardTimes[guardTimes.length - 1].end - guardTimes[0].start - minTimeAlone);
            pw.close();
            br.close();
        }
    }

    public static int aloneTime(int index, lifeguard[] guardTimes) {
        int aloneTime;
        if (index == 0) { // First one
            // Time covered - overlap in the back
            aloneTime = guardTimes[0].end - guardTimes[0].start - Math.max(0, guardTimes[0].end - guardTimes[1].start);
        } else if (index == guardTimes.length - 1) { // Last one
            // Time covered - overlap in the fromt
            aloneTime = guardTimes[index].end - guardTimes[index].start
                    - Math.max(0, guardTimes[index - 1].end - guardTimes[index].start);
        } else { // Has something in front and in the back
            int a = guardTimes[index].end - guardTimes[index].start;
            int b = Math.max(0, guardTimes[index].end - guardTimes[index + 1].start);
            int c = Math.max(0, guardTimes[index - 1].end - guardTimes[index].start);
            // System.out.println(a + " " + b + " " + c + " " + (a - b - c));
            aloneTime = a - b - c;
        }
        return aloneTime;
    }
}
