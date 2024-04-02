import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_13549 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    static int bfs() {
        int[] arr = new int[100001];
        boolean[] visited = new boolean[100001];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        arr[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                return arr[current];
            }

            int nextPosition = current * 2;
            if (nextPosition <= 100000 && !visited[nextPosition]) {
                queue.addFirst(nextPosition);
                visited[nextPosition] = true;
                arr[nextPosition] = arr[current];
            }

            int[] nextSteps = {current - 1, current + 1};
            for (int next : nextSteps) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    arr[next] = arr[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }
}
