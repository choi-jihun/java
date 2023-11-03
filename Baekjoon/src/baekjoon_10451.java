import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10451 {
    static int[] arr;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = true;

        int temp = arr[start];
        if (!visited[temp])
            dfs(temp);
    }
}
