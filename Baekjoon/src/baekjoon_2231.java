import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int sum = i;
            int current = i;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }

            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
