import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int sum;
            int end = i + 1;
            while (end < N) {
                sum = arr[i];
                sum += arr[end++];
                if (sum == M) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
