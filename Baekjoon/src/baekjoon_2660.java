import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2660 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        ArrayList<Integer> sc = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int score = Score(i);
            if (score < min) {
                min = score;
                sc.clear();
                sc.add(i);
            } else if (score == min) {
                sc.add(i);
            }
        }

        sb.append(min).append(" ").append(sc.size()).append("\n");
        for (int i : sc) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static int Score(int start) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int node : graph.get(current)) {
                if (!visited[node]) {
                    visited[node] = true;
                    dist[node] = dist[current] + 1;
                    queue.offer(node);
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, dist[i]);

        return max;
    }
}
