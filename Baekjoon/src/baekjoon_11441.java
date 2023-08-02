import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(arr[k] - arr[j - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
