import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i < N + 1; i++) {
            int sum = 0;
            for (int j = i; j < N + 1; j++) {
                sum += j;
                if (sum > N)
                    break;
                else if (sum == N) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
