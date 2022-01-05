import java.util.*;
import java.io.*;

public class tasks_and_deadlines {
    public static class task implements Comparable<task> {
        long duration;
        long deadline;

        public task(long duration, long deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }

        public int compareTo(task a) {
            if (this.duration == a.duration) {
                return (int) this.deadline - (int) a.deadline;
            }
            return (int) this.duration - (int) a.duration;
        }
    }

    public static void main(String args[]) throws IOException {
        /*
         * 
         * Why shortest duration first?
         * 
         * ans = (d1 - f1)+(d2- f2)..... ans = (d1+d2+...) - (f1+f2+...)
         * 
         * t1 = 3 seconds t2 = 1 second
         * 
         * t1 then t2 = 3 + 4 = 7 t2 then t1 = 1 + 4 = 5
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalTasks = Integer.parseInt(st.nextToken());
        task[] tasks = new task[totalTasks];

        for (int x = 0; x < totalTasks; x++) {
            st = new StringTokenizer(br.readLine());
            tasks[x] = new task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(tasks);

        long time = 0;
        long reward = 0;

        for (task x : tasks) {
            time += x.duration;
            reward += x.deadline - time;
        }
        System.out.println(reward);
    }
}