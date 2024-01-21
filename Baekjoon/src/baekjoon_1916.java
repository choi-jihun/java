import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Graph implements Comparable<Graph> {
    int idx;
    int cost;

    Graph(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Graph o) {
        return this.cost - o.cost;
    }
}

public class baekjoon_1916 {
    static ArrayList<ArrayList<Graph>> graph = new ArrayList<>();
    static int start, end;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Graph(b, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        shortest_path();
        System.out.println(dist[end]);
    }

    static void shortest_path() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Graph> queue = new PriorityQueue<>();
        queue.offer(new Graph(start, 0));

        while (!queue.isEmpty()) {
            Graph g = queue.poll();
            int current = g.idx;
            if (dist[current] < g.cost) {
                continue;
            }

            for (Graph gra : graph.get(current)) {
                if (dist[gra.idx] > dist[current] + gra.cost) {
                    dist[gra.idx] = dist[current] + gra.cost;
                    queue.offer(new Graph(gra.idx, dist[gra.idx]));
                }
            }
        }
    }
}
