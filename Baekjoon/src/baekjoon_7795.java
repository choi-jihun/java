import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(B);
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int start = 0;
                int end = M - 1;
                int idx = 0;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (B[mid] < A[i]) {
                        start = mid + 1;
                        idx = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                cnt += idx;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
