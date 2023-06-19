import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i = N; i <= M; i++) {
                int temp = i;

                if (temp == 0) {
                    cnt++;
                    continue;
                }

                while (temp > 1) {
                    if (temp % 10 == 0)
                        cnt++;
                    temp /= 10;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
