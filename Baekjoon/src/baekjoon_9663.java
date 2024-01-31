import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9663 {
    static int[] arr;
    static int cnt, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = 0;

        backTracking(0);
        System.out.println(cnt);
    }

    static void backTracking(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean safe = true;

            for (int j = 0; j < row; j++) {
                if (arr[j] == i || Math.abs(row - j) == Math.abs(i - arr[j])) {
                    safe = false;
                    break;
                }
            }
            if (safe) {
                arr[row] = i;
                backTracking(row + 1);
            }
        }
    }

}
