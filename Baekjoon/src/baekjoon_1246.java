import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int tmp = 0;
            if (M - i < N)
                tmp = arr[i] * (M - i);
            else
                tmp = arr[i] * N;

            if (tmp > max) {
                max = tmp;
                ans = arr[i];
            }
        }
        System.out.println(ans + " " + max);
    }
}
