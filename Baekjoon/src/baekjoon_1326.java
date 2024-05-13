import java.io.*;
import java.util.*;

public class baekjoon_1326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] stones = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == b) {
            bw.write("0\n");
        } else {
            int answer = bfs(N, stones, a, b);
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int N, int[] stones, int start, int end) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0];
            int jumpCount = current[1];

            int step = stones[currentPosition];
            for (int nextPosition = currentPosition + step; nextPosition <= N; nextPosition += step) {
                if (nextPosition == end) {
                    return jumpCount + 1;
                }
                if (!visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.offer(new int[]{nextPosition, jumpCount + 1});
                }
            }
            for (int prevPosition = currentPosition - step; prevPosition >= 1; prevPosition -= step) {
                if (prevPosition == end) {
                    return jumpCount + 1;
                }
                if (!visited[prevPosition]) {
                    visited[prevPosition] = true;
                    queue.offer(new int[]{prevPosition, jumpCount + 1});
                }
            }
        }

        return -1;
    }

}
