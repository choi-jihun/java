import java.io.*;
import java.util.*;

public class baekjoon_18352 {

    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dis = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dis, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        bfs(X);
        boolean exists = false;
        for (int i = 1; i <= N; i++) {
            if (dis[i] == K) {
                bw.write(i + "\n");
                exists = true;
            }
        }

        if (!exists) {
            bw.write("-1\n");
        }

        bw.flush();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (dis[next] == -1) {
                    dis[next] = dis[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
