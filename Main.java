import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Long, Integer> frequency = new HashMap<>();
        frequency.put(Long.valueOf(0), 1);
        long sum = 0;
        long ans = 0;
        for (int x = 0; x < n; x++) {
            sum += Long.parseLong(st.nextToken());

            if (frequency.containsKey(((sum % n) + n) % n))
                ans += Long.valueOf(frequency.get(((sum % n) + n) % n));
            frequency.putIfAbsent(((sum % n) + n) % n, 0);
            frequency.put(((sum % n) + n) % n, frequency.get(((sum % n) + n) % n) + 1);
        }
        System.out.println(ans);
    }
}
