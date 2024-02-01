import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2239 {
    static int[][] ch;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                ch[i][j] = str.charAt(j) - '0';
            }
        }
        sudoku(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(ch[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean sudoku(int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9)
                return true;
        }

        if (ch[row][col] != 0) {
            return sudoku(row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (check(row, col, i)) {
                ch[row][col] = i;
                if (sudoku(row, col + 1))
                    return true;

                ch[row][col] = 0;
            }
        }

        return false;
    }

    static boolean check(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (ch[row][i] == num || ch[i][col] == num ||
                    ch[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
