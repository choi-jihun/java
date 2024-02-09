import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_1240 {

    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int[] distances;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, distance));
            graph.get(b).add(new Node(a, distance));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            distances = new int[N + 1];
            visited = new boolean[N + 1];


            dfs(start, 0);
            sb.append(distances[end]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;
        distances[node] = distance;

        for (Node neighbor : graph.get(node)) {
            if (!visited[neighbor.node]) {
                dfs(neighbor.node, distance + neighbor.distance);
            }
        }
    }
}
