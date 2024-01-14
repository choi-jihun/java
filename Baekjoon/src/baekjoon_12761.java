import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_12761 {
    static int A, B, N, M;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        int cnt = 0;

        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == M) {
                    return cnt;
                }

                int[] next = {current + 1, current - 1, current + A, current - A, current + B, current - B, current * A, current * B};
                for (int nextStep : next) {
                    if (nextStep >= 0 && nextStep <= 100000 && !visited[nextStep]) {
                        queue.offer(nextStep);
                        visited[nextStep] = true;
                    }
                }
            }
            cnt++;
        }
    }
}
