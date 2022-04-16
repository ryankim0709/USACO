import java.util.*;
import java.io.*;

public class milk_measurement {
    static class Entry implements Comparable<Entry> {
        int date, cow, diff;

        public Entry(int date, int cow, int diff) {
            this.date = date;
            this.cow = cow;
            this.diff = diff;
        }

        public int compareTo(Entry a) {
            return this.date - a.date;
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Entry[] log = new Entry[N];

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            log[x] = new Entry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        br.close();
        Arrays.sort(log);
        HashMap<Integer, Integer> production = new HashMap<>();
        TreeMap<Integer, Integer> finalProduction = new TreeMap<>();
        finalProduction.put(G, (int) (1e9));

        int switches = 0;

        for (int x = 0; x < N; x++) {
            Entry a = log[x];

            if (!production.containsKey(a.cow)) {
                production.put(a.cow, G);
            }

            int prev_val = production.get(a.cow);
            production.put(a.cow, prev_val + a.diff);
            int new_val = production.get(a.cow);

            int old_max = finalProduction.lastKey();
            if (new_val > prev_val) {
                if (prev_val == old_max && finalProduction.get(old_max) != 1) {
                    switches++;
                }
                if (prev_val != old_max && new_val >= old_max) {
                    switches++;
                }
            } else { // new_val < prev_val
                if (prev_val == old_max && finalProduction.get(old_max) == 1) {
                    int new_max = Math.max(new_val, finalProduction.lowerKey(old_max));
                    if (new_val < new_max)
                        switches++;
                    else {
                        if (finalProduction.containsKey(new_max))
                            switches++;
                    }
                }
                if (prev_val == old_max && finalProduction.get(old_max) != 1) {
                    switches++;
                }
            }
            finalProduction.put(prev_val, finalProduction.get(prev_val) - 1);
            if (finalProduction.get(prev_val) == 0) {
                finalProduction.remove(prev_val);
            }

            finalProduction.putIfAbsent(new_val, 0);
            finalProduction.put(new_val, finalProduction.get(new_val) + 1);
        }
        // System.out.println(switches);
        pw.print(switches);
        pw.close();
    }
}