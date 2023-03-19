import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            double sum = 0;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double avg = sum / N;
            for (int j = 0; j < N; j++) {
                if (arr[j] > avg)
                    cnt++;
            }
            sb.append(String.format("%.3f%%", (double) cnt / N * 100)).append("\n");
        }
        System.out.println(sb);
    }
}
