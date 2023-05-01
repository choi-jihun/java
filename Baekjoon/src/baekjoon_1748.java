import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int ans = 0;
        int num = 10;
        for (int i = 1; i <= N; i++) {
            if (i == num) {
                cnt++;
                num *= 10;
            }
            ans += cnt;
        }
        System.out.println(ans);
    }
}
