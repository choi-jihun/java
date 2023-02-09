import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1697 {

    static int[] visit;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new int[100001];
        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = 1;
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n == K)
                return visit[n] - 1;
            if (n - 1 >= 0 && visit[n - 1] == 0) {
                visit[n - 1] = visit[n] + 1;
                q.add(n - 1);
            }
            if (n + 1 < 100001 && visit[n + 1] == 0) {
                visit[n + 1] = visit[n] + 1;
                q.add(n + 1);
            }
            if (2 * n < 100001 && visit[2 * n] == 0) {
                visit[2 * n] = visit[n] + 1;
                q.add(2 * n);
            }
        }
        return 0;
    }

}
