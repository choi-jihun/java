import java.io.*;
import java.util.*;

public class baekjoon_1263 {
    static class Task implements Comparable<Task> {
        int time, deadline;

        public Task(int time, int deadline) {
            this.time = time;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.deadline, other.deadline);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(time, deadline);
        }

        Arrays.sort(tasks);

        int currentTime = tasks[N - 1].deadline;

        for (int i = N - 1; i >= 0; i--) {
            currentTime = Math.min(currentTime, tasks[i].deadline);
            currentTime -= tasks[i].time;
            if (currentTime < 0) {
                bw.write("-1\n");
                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write(currentTime + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
