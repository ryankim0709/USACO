import java.util.*;
import java.io.*;

public class traffic_lights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        TreeSet<Integer> lights = new TreeSet<>();
        // ArrayList<Integer> diffs = new ArrayList<>();

        TreeMap<Integer, Integer> diffs2 = new TreeMap<>();

        lights.add(0);
        lights.add(x);
        // diffs.add(x);

        diffs2.put(x, 1);

        st = new StringTokenizer(br.readLine());

        int lightPos, max, min;
        for (int y = 0; y < n; y++) {
            lightPos = Integer.parseInt(st.nextToken());
            max = lights.higher(lightPos);
            min = lights.lower(lightPos);
            lights.add(lightPos);
            // diffs.remove(max - min);
            // diffs.add(max - lightPos);
            // diffs.add(lightPos - min);

            diffs2.put(max - min, diffs2.get(max - min) - 1);
            if (!diffs2.containsKey(max - lightPos)) {
                diffs2.put(max - lightPos, 0);
            }
            if (!diffs2.containsKey(lightPos - min)) {
                diffs2.put(lightPos - min, 0);
            }
            diffs2.put(max - lightPos, diffs2.get(max - lightPos) + 1);
            diffs2.put(lightPos - min, diffs2.get(lightPos - min) + 1);

            if (diffs2.get(max - min) == 0) {
                diffs2.remove(max - min);
            }
            System.out.print(diffs2.lastKey() + " ");
        }
    }
}
