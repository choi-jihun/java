import java.io.*;
import java.util.*;

public class baekjoon_6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int maxDistance = 0;
        int barnNumber = 0;
        int barnCount = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDistance) {
                maxDistance = dist[i];
                barnNumber = i;
                barnCount = 1;
            } else if (dist[i] == maxDistance) {
                barnCount++;
            }
        }

        bw.write(barnNumber + " " + maxDistance + " " + barnCount + "\n");
        bw.flush();
        bw.close();
    }
}
