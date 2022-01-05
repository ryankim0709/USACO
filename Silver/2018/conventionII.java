import java.util.*;
import java.io.*;

public class conventionII {
    static class Cow {
        int arrival, time, seniority;

        public Cow(int arrival, int time, int seniorty) {
            this.arrival = arrival;
            this.time = time;
            this.seniority = seniorty;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            cows[x] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), x);
        }
        br.close();
        Arrays.sort(cows, Comparator.comparingInt(r -> r.arrival));

        PriorityQueue<Cow> PQ = new PriorityQueue<>((Cow1, Cow2) -> {
            return Cow1.seniority - Cow2.seniority;
        });

        int time = cows[0].arrival;
        int ans = 0;

        int index = 0;
        for (int x = 0; x < N; x++) {
            // Compile PriorityQueue
            if (index < N - 1) {
                while (cows[index].arrival <= time) {
                    PQ.add(cows[index]);
                    index++;
                }
            }

            if (PQ.size() == 0) {
                time = cows[index].arrival;
                PQ.add(cows[index]);
                index++;
            }

            Cow taster = PQ.peek();
            ans = Math.max(ans, time - taster.arrival);
            time += taster.time;
            PQ.poll();
        }
        // System.out.println(ans);
        pw.print(ans);
        pw.close();
    }
}