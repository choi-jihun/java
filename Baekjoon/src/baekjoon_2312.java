import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 2; i <= N; i++) {
                int cnt = 0;
                while (N % i == 0) {
                    N /= i;
                    cnt++;
                }
                if (cnt != 0) {
                    sb.append(i).append(" ").append(cnt).append("\n");
                }
                if (N == 0)
                    break;
            }
        }

        System.out.println(sb);
    }
}
