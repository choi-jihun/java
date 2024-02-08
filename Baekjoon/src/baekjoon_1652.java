import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] ch = new char[N][N];
        for (int i = 0; i < N; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        int horizontalCount = 0;
        for (int i = 0; i < N; i++) {
            int emptyCount = 0;
            for (int j = 0; j < N; j++) {
                if (ch[i][j] == '.') {
                    emptyCount++;
                } else {
                    if (emptyCount >= 2) {
                        horizontalCount++;
                    }
                    emptyCount = 0;
                }
            }
            if (emptyCount >= 2) {
                horizontalCount++;
            }
        }

        int verticalCount = 0;
        for (int j = 0; j < N; j++) {
            int emptyCount = 0;
            for (int i = 0; i < N; i++) {
                if (ch[i][j] == '.') {
                    emptyCount++;
                } else {
                    if (emptyCount >= 2) {
                        verticalCount++;
                    }
                    emptyCount = 0;
                }
            }
            if (emptyCount >= 2) {
                verticalCount++;
            }
        }

        System.out.println(horizontalCount + " " + verticalCount);
    }
}
