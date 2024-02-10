import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2580 {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
    }

    static void backTracking(int row, int col) {
        if (col == 9) {
            backTracking(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(row, col, i)) {
                    arr[row][col] = i;
                    backTracking(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        backTracking(row, col + 1);
    }


    static boolean isValid(int row, int col, int num) {
        return usedInRow(row, num) && usedInColumn(col, num) && usedInBox(row - row % 3, col - col % 3, num);
    }

    static boolean usedInRow(int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    static boolean usedInColumn(int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    static boolean usedInBox(int boxStartRow, int boxStartCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int col = 0; col < 3; col++) {
                if (arr[i + boxStartRow][col + boxStartCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
