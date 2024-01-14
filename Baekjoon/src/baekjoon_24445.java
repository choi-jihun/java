import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_24445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        int[] order = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[R] = true;
        queue.offer(R);
        int cnt = 1;
        order[R] = cnt++;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int next : graph.get(currentNode)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    order[next] = cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (order[i] == 0) {
                System.out.println(0);
            } else {
                System.out.println(order[i]);
            }
        }
    }
}
