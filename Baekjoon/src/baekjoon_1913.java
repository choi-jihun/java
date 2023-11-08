import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1913 {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        makeArr();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == K) {
                    x = i + 1;
                    y = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }

    static void makeArr() {
        int x = 0, y = 0, idx = 0;
        arr[x][y] = N * N;
        while (true) {
            int nX = x + dx[idx];
            int nY = y + dy[idx];

            if (nX >= 0 && nX < N && nY >= 0 && nY < N && arr[nX][nY] == 0) {
                arr[nX][nY] = arr[x][y] - 1;
                if (arr[nX][nY] == 1)
                    return;
                x = nX;
                y = nY;
            } else {
                idx++;
            }

            if (idx >= 4)
                idx = 0;
        }
    }
}
