import java.io.*;
import java.util.*;

public class baekjoon_15591 {
    static class Edge {
        int to;
        int usado;
        Edge(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }

    static List<List<Edge>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph.get(p).add(new Edge(q, r));
            graph.get(q).add(new Edge(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bw.write(bfs(k, v) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int k, int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[graph.size()];
        queue.offer(v);
        visited[v] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Edge edge : graph.get(curr)) {
                if (!visited[edge.to] && edge.usado >= k) {
                    visited[edge.to] = true;
                    queue.offer(edge.to);
                    count++;
                }
            }
        }
        return count;
    }
}