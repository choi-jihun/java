import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int real_n = 0;
        int real_cnt = 0;
        int fake_n = 0;
        int fake_cnt = 0;

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] roll = new int[L];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            if (fake_cnt < (k - p)) {
                fake_cnt = k - p;
                fake_n = i;
            }

            int cnt = 0;
            for (int j = p; j <= k; j++) {
                if (roll[j] == 0) {
                    roll[j] = i;
                    cnt++;
                }
            }
            if (cnt > real_cnt) {
                real_n = i;
                real_cnt = cnt;
            }
        }
        System.out.println(fake_n);
        System.out.println(real_n);
    }
}
