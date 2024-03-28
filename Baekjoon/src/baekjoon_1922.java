import java.io.*;
import java.util.*;

public class baekjoon_1922 {

    static class Node implements Comparable<Node> {
        int des;
        int cost;

        public Node(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static int min;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        min = 0;
        prim();
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    static void prim() {
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.des;
            int c = node.cost;

            if (visit[v]) {
                continue;
            }

            visit[v] = true;
            min += c;

            for (Node n : graph.get(v)) {
                if (!visit[n.des]) {
                    pq.offer(n);
                }
            }
        }
    }

}
