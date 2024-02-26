import java.io.*;
import java.util.*;

public class baekjoon_1005 {

    static int N, K;
    static List<List<Integer>> graph;
    static int[] time;
    static int[] degree;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            degree = new int[N + 1];
            dp = new int[N + 1];
            graph = new ArrayList<>();

            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph.get(X).add(Y);
                degree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());
            bfs();
            bw.write(dp[W] + "\n");
        }
        bw.flush();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (dp[next] < dp[current] + time[next]) {
                    dp[next] = dp[current] + time[next];
                }
                degree[next]--;

                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
