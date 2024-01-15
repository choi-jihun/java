import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_16928 {
    static int[] latterAndSnake = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] count = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            latterAndSnake[a] = b;
        }
        BFS();
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        count[1] = 0;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == 100) {
                System.out.println(count[current]);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int nextX = i + current;
                if (nextX > 100) {
                    continue;
                }
                if (visited[nextX]) {
                    continue;
                }

                visited[nextX] = true;
                if (latterAndSnake[nextX] != 0) {
                    if (!visited[latterAndSnake[nextX]]) {
                        queue.offer(latterAndSnake[nextX]);
                        visited[latterAndSnake[nextX]] = true;
                        count[latterAndSnake[nextX]] = count[current] + 1;
                    }
                } else {
                    queue.offer(nextX);
                    count[nextX] = count[current] + 1;
                }
            }
        }
    }
}
