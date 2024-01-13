import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        q.offer(new int[]{S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentFloor = current[0];
            int cnt = current[1];

            if (currentFloor == G) {
                System.out.println(cnt);
                return;
            }

            int up = currentFloor + U;
            if (up <= F && !visited[up]) {
                q.offer(new int[]{up, cnt + 1});
                visited[up] = true;
            }

            int down = currentFloor - D;
            if (down >= 1 && !visited[down]) {
                q.offer(new int[]{down, cnt + 1});
                visited[down] = true;
            }
        }

        System.out.println("use the stairs");
    }
}
