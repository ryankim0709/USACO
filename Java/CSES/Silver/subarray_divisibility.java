import java.util.*;
import java.io.*;

public class subarray_divisibility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> frequency = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int x = 0; x < n; x++) {
            sum += Integer.parseInt(st.nextToken());

            if (frequency.containsKey(sum % n))
                ans += frequency.get(sum % n);
            frequency.putIfAbsent(sum, 0);
            frequency.put(sum, frequency.get(sum) + 1);
        }
        System.out.println(ans);
    }
}
