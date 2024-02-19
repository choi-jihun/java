import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_11657 {

    static class Node {
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static int N, M;
    static List<List<Node>> graph;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        if (BellmanFord()) {
            for (int i = 2; i < N + 1; i++) {
                bw.write((dist[i] != Long.MAX_VALUE ? dist[i] : -1) + "\n");
            }
        } else {
            bw.write("-1");
        }
        bw.flush();
    }

    static boolean BellmanFord() {
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Node node : graph.get(j)) {
                    if (dist[j] != Long.MAX_VALUE && dist[j] + node.cost < dist[node.end]) {
                        dist[node.end] = dist[j] + node.cost;
                    }
                }
            }
        }

        for (int j = 1; j <= N; j++) {
            for (Node node : graph.get(j)) {
                if (dist[j] != Long.MAX_VALUE && dist[j] + node.cost < dist[node.end]) {
                    return false;
                }
            }
        }

        return true;
    }

}
