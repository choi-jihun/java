import java.io.*;
import java.util.*;

public class baekjoon_1197 {

    static class Node implements Comparable<Node> {
        int w;
        int cost;

        Node(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int V, E;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        prim(1);
        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void prim(int start) {
        boolean[] visit = new boolean[V + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if (visit[v])
                continue;

            visit[v] = true;
            total += cost;

            for (Node e : graph.get(v)) {
                if (!visit[e.w]) {
                    pq.add(e);
                }
            }
        }
    }
}
