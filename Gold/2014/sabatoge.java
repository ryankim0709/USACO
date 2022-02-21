import java.util.*;
import java.io.*;

public class sabatoge {
    static int[] machines = new int[100000];
    static int totalSum = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("sabotage.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sabotage.out")));
        N = Integer.parseInt(br.readLine());
        for (int x = 0; x < N; x++) {
            machines[x] = Integer.parseInt(br.readLine());
            totalSum += machines[x];
        }
        br.close();
        double lo = 1.0;
        double high = N * 1000.0;

        while (round3(lo) != round3(high)) {
            double mid = lo + (high - lo) / 2.0;
            if (check(mid))
                high = mid;
            else
                lo = mid;

            System.out.println(
                    "High: " + high + " Low: " + lo + " Mid: " + String.format("%.4f", (lo + (high - lo) / 2)));
        }
        // System.out.format("%.3f", lo);
        pw.printf("%.3f", lo);
        pw.close();
    }

    public static boolean check(Double P) {
        double[] temp = new double[N];

        for (int x = 0; x < N; x++) {
            temp[x] = (double) machines[x] - P;
        }

        double maxSum = temp[1];
        double currSum = temp[1];
        for (int x = 2; x < N - 1; x++) {
            currSum = Math.max(currSum, 0);
            currSum += temp[x];
            maxSum = Math.max(maxSum, currSum);
        }

        return ((double) totalSum - (N * P) - maxSum) <= 0;
    }

    public static int round3(Double number) {
        return (int) (1000.0 * number + 0.5);
    }
}
