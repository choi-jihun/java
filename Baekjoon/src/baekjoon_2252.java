import java.io.*;
import java.util.*;

public class baekjoon_2252 {

    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            arr[b]++;
        }
        bfs();
        bw.write(sb.toString());
        bw.flush();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (arr[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");
            for (int next : graph.get(current)) {
                if (--arr[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
