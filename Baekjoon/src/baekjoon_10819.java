import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10819 {
    static int[] num;
    static int[] temp;
    static boolean[] visited;
    static int N;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        temp = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        DFS(0);
        System.out.println(ans);
    }

    static void DFS(int count) {
        if (count == N) {
            ans = Math.max(getMax(), ans);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[count] = num[i];
                DFS(count + 1);
                visited[i] = false;
            }
        }
    }

    static int getMax() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++)
            sum += Math.abs(temp[i] - temp[i + 1]);
        return sum;
    }
}
