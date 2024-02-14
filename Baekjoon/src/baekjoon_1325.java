import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1325 {
    /* 시간초과
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(B).add(A);
        }

        result = new int[N + 1];
        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
            }
        }

        for (int res : result) {
            max = Math.max(res, max);
        }

        for (int i = 1; i < N + 1; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        result[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int node : graph.get(current)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                    count++;
                    result[node] = count;
                }
            }
        }
        result[start] = count;
    }*/
}
