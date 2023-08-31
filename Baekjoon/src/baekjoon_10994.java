import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10994 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 1 + 4 * (N - 1);
        arr = new char[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++)
                arr[i][j] = ' ';
        }

        pointStar(0, M);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void pointStar(int n, int m) {
        for (int i = n; i < m; i++) {
            arr[n][i] = '*';
            arr[m - 1][i] = '*';
            arr[i][n] = '*';
            arr[i][m - 1] = '*';
        }

        if (m == 1) return;

        pointStar(n + 2, m - 2);
    }
}
