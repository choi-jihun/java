import java.io.*;
import java.util.*;

public class baekjoon_18223 {

    static final int INF = 1000000000;
    static List<List<Node>> graph;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        dijkstra(1);
        int dist1toV = dist[V];
        int dist1toP = dist[P];

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dijkstra(P);
        int distPtoV = dist[V];

        if (dist1toP + distPtoV == dist1toV) {
            bw.write("SAVE HIM\n");
        } else {
            bw.write("GOOD BYE\n");
        }

        bw.flush();

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.to;

            if (current.cost > dist[u]) {
                continue;
            }

            for (Node next : graph.get(u)) {
                int v = next.to;
                int cost = next.cost;

                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }
}
