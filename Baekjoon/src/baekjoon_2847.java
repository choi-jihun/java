import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] levels = new int[N];

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(br.readLine());
            levels[i] = score;
        }

        if (N == 1)
            System.out.println(0);
        else {
            int cnt = 0;

            for (int i = N - 2; i >= 0; i--) {
                int high = levels[i + 1];
                int low = levels[i];

                if (low >= high) {
                    cnt += low - (high - 1);
                    levels[i] = high - 1;
                }
            }
            System.out.println(cnt);
        }
    }
}
