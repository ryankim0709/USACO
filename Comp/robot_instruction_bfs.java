import java.util.*;
import java.io.*;

public class robot_instruction_bfs {
    static class Obj {
        long x, y, step, bitmap;

        public Obj(long x, long y, long step, long bitmap) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.bitmap = bitmap;
        }
    }

    static HashMap<Integer, String> instructions = new HashMap<>();
    static long tarX = 0;
    static long tarY = 0;
    static HashMap<Long, Long> ans = new HashMap<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tarX = Long.parseLong(st.nextToken());
        tarY = Long.parseLong(st.nextToken());
        for (int i = 0; i < N; i++) {
            ans.put(Long.valueOf(i + 1), Long.valueOf(0));
            instructions.put(i, br.readLine());
        }
        bfs();
        
        for (Long i : ans.values()) {
            System.out.println(i);
        }
    }
    
    public static void bfs() {
        // bitmap | (0x1 << i)
        // ((bitmap >> i) & 0x1)
       
        Queue<Obj> q = new LinkedList<>();
        q.add(new Obj(0, 0, 0, 0));
        
        long latest_step = 0;
        HashSet<Long> ans_set = new HashSet<>();

        while (q.size() > 0 && latest_step <= N) {
            long x = q.peek().x; long y = q.peek().y;
            long step = q.peek().step;
            long bitmap = q.poll().bitmap;
            
            if (x == tarX && y == tarY) {
                if (!ans_set.contains(bitmap)) {
                    ans.put(step, ans.get(step) + 1);
                    ans_set.add(bitmap);
                    continue;
                }
            }
            latest_step = Math.max(latest_step, step);

            for (int i = 0; i < N; i++) {
                if (((bitmap >> i) & 0x1) == 1) {
                    continue;
                }
                String instruction = instructions.get(i);
                Long newX = x + Long.parseLong(instruction.split(" ")[0]);
                Long newY = y + Long.parseLong(instruction.split(" ")[1]);
                q.add(new Obj(newX, newY, step + 1, bitmap | (0x1 << i)));
            }
        }
    }
}