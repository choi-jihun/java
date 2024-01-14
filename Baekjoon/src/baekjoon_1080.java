import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1080 {
    static int N, M;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = str.charAt(j) - '0';
            }
        }

        if (N < 3 || M < 3) {
            if (isSame()) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int cnt = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(i, j);
                    cnt++;
                }
            }
        }

        if (isSame()) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }

    }

    static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
    }

    static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
