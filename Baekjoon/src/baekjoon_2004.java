import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt1 = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);
        int cnt2 = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);

        System.out.println(Math.min(cnt1, cnt2));
    }

    static int countFactors(int num, int factor) {
        int cnt = 0;
        while (num > 0) {
            num /= factor;
            cnt += num;
        }
        return cnt;
    }
}
