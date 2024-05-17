import java.io.*;
import java.util.*;

public class baekjoon_14248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(s);
        visited[s] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            int left = current - A[current];
            int right = current + A[current];

            if (left >= 1 && !visited[left]) {
                queue.add(left);
                visited[left] = true;
            }

            if (right <= n && !visited[right]) {
                queue.add(right);
                visited[right] = true;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
