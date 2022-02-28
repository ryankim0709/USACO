import java.util.*;
import java.io.*;

public class robot_instruction_dfs {
    static HashMap<Integer, String> instructions = new HashMap<>();
    static long tarX = 0;
    static long tarY = 0;
    static HashMap<Long, Long> ans = new HashMap<>();
    static int N;
    static Long bitmap = Long.valueOf(0);
    static int[] tracked;
    static HashSet<Long> ans_set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tracked = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        tarX = Long.parseLong(st.nextToken());
        tarY = Long.parseLong(st.nextToken());
        for (int i = 0; i < N; i++) {
            tracked[i] = i;
            ans.put(Long.valueOf(i + 1), Long.valueOf(0));
            instructions.put(i, br.readLine());
        }
        dfs(0, 0, 0, 0, 0);
        
        for (Long i : ans.values()) {
            System.out.println(i);
        }
    }
    
    public static void swap(int a, int b) {
        int x = tracked[a];
        int y = tracked[b];
        tracked[a] = y;
        tracked[b] = x;
    }
    public static void dfs(int current_idx, long x, long y, int step, long bitmap) {
        // bitmap | (0x1 << i)
        // ((bitmap >> i) & 0x1)
        
        if (current_idx == N) {
            return;
        }

        if (x == tarX && y == tarY) {
            if (!ans_set.contains(bitmap)) {
                ans.put(Long.valueOf(step), Long.valueOf(ans.get(Long.valueOf(step)) + 1));
                ans_set.add(bitmap);
            }
            return;
        }
        
        for (int i = current_idx; i < N; i++) {
            swap(i, current_idx);
            String instruction = instructions.get(i);
            Long newX = x + Long.parseLong(instruction.split(" ")[0]);
            Long newY = y + Long.parseLong(instruction.split(" ")[1]);
            dfs(current_idx + 1, newX, newY, step + 1, bitmap | (0x1 << tracked[current_idx]));
            swap(i, current_idx);
        }
    }
}