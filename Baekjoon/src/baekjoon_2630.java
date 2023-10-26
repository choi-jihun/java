import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        colorCount(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void colorCount(int x, int y, int size) {
        if (colorCheck(x, y, size)) {
            if (arr[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }

        int newSize = size / 2;

        colorCount(x, y, newSize);
        colorCount(x + newSize, y, newSize);
        colorCount(x, y + newSize, newSize);
        colorCount(x + newSize, y + newSize, newSize);
    }

    static boolean colorCheck(int x, int y, int size) {
        int color = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
