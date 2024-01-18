import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_14567 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;
    static int[] semester;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        semester = new int[N + 1];
        num = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            num[B]++;
        }
        Sort();
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void Sort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (num[i] == 0) {
                queue.offer(i);
                semester[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int node : graph.get(current)) {
                num[node]--;
                if (num[node] == 0) {
                    queue.offer(node);
                    semester[node] = semester[current] + 1;
                }
            }
        }
    }
}
