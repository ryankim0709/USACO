import java.util.*;
import java.io.*;

public class jobs {
	static int[] jobs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());  // Days company has
		int D = Integer.parseInt(st.nextToken());  // Max Delay
		int M = Integer.parseInt(st.nextToken());  // # of jobs
		st = new StringTokenizer(br.readLine());

		jobs = new int[M];

		for(int x = 0; x < M; x++) {
			jobs[x] = Integer.parseInt(st.nextToken());
		}

	}
}
