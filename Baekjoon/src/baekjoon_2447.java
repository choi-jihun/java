import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2447{

    static char[][] stars;
    static int len;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());

        stars = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                stars[i][j] = ' ';
            }
        }
        StringBuilder sb = new StringBuilder();
        recursive(0, 0, len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recursive(int x, int y, int size) {
        if (size == 1) {
            stars[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    recursive(x + newSize * i, y + newSize * j, newSize);
                }
            }
        }
    }

}

