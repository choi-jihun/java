import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1753 {

    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int V, E, K;
    static boolean[] check;

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }
        dijkstra(K, V);
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        check = new boolean[N + 1];
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node queNode = pq.poll();
            int startNum = queNode.num;
            if (!check[startNum]) {
                check[startNum] = true;
                for (Node node : graph.get(startNum)) {
                    if (!check[node.num] && dist[node.num] > (dist[startNum] + node.weight)) {
                        dist[node.num] = dist[startNum] + node.weight;
                        pq.offer(new Node(node.num, dist[node.num]));
                    }
                }
            }
        }
    }
}