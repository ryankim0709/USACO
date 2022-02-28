import java.util.*;
import java.io.*;

public class Robot_Instructions {
    static HashMap<Integer, String> instructions = new HashMap<>();
    static long tarX = 0;
    static long tarY = 0;
    static HashMap<Integer, Integer> ans = new HashMap<>();
    static int N;
    static long maxx = Long.valueOf(100000000);
    static long minn = Long.valueOf(-1000000000);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tarX = Long.parseLong(st.nextToken());
        tarY = Long.parseLong(st.nextToken());
        for (int i = 0; i < N; i++) {
            ans.put(i + 1, 0);
            instructions.put(i, br.readLine());
        }
        dfs(Long.valueOf(0), Long.valueOf(0), 0, Long.valueOf(0));
        for (int i : ans.values()) {
            System.out.println(i);
        }
    }
    
    public static void dfs(Long x, Long y, int steps, Long bitmap) {
        if (steps >= N || x > maxx || y > maxx || x < minn || y < minn) {
            return;
        }
        if (x == tarX && y == tarY) {
            ans.put(steps, ans.get(steps) + 1);
            System.out.println(bitmap);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (((bitmap >> i) & 0x1) != 1) {
                String instruction = instructions.get(i);
                Long newX = x + Long.parseLong(instruction.split(" ")[0]);
                Long newY = y + Long.parseLong(instruction.split(" ")[1]);
                // System.out.println(bitmap);
                // System.out.println(bitmap | (0x1 << i));
                // System.out.println(newX);
                // System.out.println(newY);
                dfs(newX, newY, steps + 1, bitmap | (0x1 << i));                
            } 
        }
    }
}