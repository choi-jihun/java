import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1389 {
    static int arr[][];
    static boolean visited[];

    static int N;
    static int ans;
    static int min_count = Integer.MAX_VALUE;

    static class Bacon {
        int num;
        int value;

        public Bacon(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
            arr[x][y] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        System.out.println(ans);
    }

    static void BFS(int start) {
        Queue<Bacon> que = new LinkedList<>();
        int cnt = 0;

        visited[start] = true;
        que.offer(new Bacon(start, 0));

        while (!que.isEmpty()) {
            Bacon bacon = que.poll();
            cnt += bacon.value;

            for (int i = 1; i < N + 1; i++) {
                int temp = arr[bacon.num][i];

                if (temp == 1 && !visited[i]) {
                    visited[i] = true;
                    que.offer(new Bacon(i, bacon.value + 1));
                }
            }
        }

        if (min_count > cnt) {
            min_count = cnt;
            ans = start;
        }
    }
}
