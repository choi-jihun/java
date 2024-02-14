import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_14891 {
    static int[][] arr;
    static int select, direction;
    static int[] isTurn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            select = Integer.parseInt(st.nextToken()) - 1;
            direction = Integer.parseInt(st.nextToken());
            isTurn = new int[4];
            isTurn[select] = direction;
            rotate();
        }
        bw.write(calculateScore() + "");
        bw.flush();
    }

    static void rotate() {
        int leftDirection = direction * -1;
        int rightDirection = direction * -1;

        int leftIdx = select - 1;
        int rightIdx = select + 1;
        while (leftIdx >= 0) {
            if (arr[leftIdx][2] != arr[leftIdx + 1][6]) {
                isTurn[leftIdx] = leftDirection;
                leftDirection *= -1;
            } else {
                break;
            }
            leftIdx--;
        }

        while (rightIdx < 4) {
            if (arr[rightIdx][6] != arr[rightIdx - 1][2]) {
                isTurn[rightIdx] = rightDirection;
                rightDirection *= -1;
            } else {
                break;
            }
            rightIdx++;
        }

        for (int i = 0; i < 4; i++) {
            sideRotate(i, isTurn[i]);
        }

    }

    static void sideRotate(int idx, int opposite) {
        if (opposite == 0)
            return;

        int[] temp = new int[8];
        for (int i = 0; i < 8; i++) {
            temp[i] = arr[idx][i];
        }

        if (opposite == 1) {
            for (int i = 0; i < 7; i++) {
                arr[idx][i + 1] = temp[i];
            }
            arr[idx][0] = temp[7];
        } else if (opposite == -1) {
            for (int i = 7; i > 0; i--) {
                arr[idx][i - 1] = temp[i];
            }
            arr[idx][7] = temp[0];
        }
    }

    static int calculateScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += Math.pow(2, i) * arr[i][0];
        }
        return score;
    }
}
