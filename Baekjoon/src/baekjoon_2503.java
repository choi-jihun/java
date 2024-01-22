import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] baseball = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            baseball[i][0] = Integer.parseInt(st.nextToken());
            baseball[i][1] = Integer.parseInt(st.nextToken());
            baseball[i][2] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 123; i <= 987; i++) {
            if (isPossibleAnswer(i, baseball) && isValidNumber(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isValidNumber(int number) {
        int hundred = number / 100;
        int ten = (number / 10) % 10;
        int one = number % 10;

        return hundred != ten && hundred != one && ten != one && hundred != 0 && ten != 0 && one != 0;
    }

    static boolean isPossibleAnswer(int number, int[][] questions) {
        for (int[] question : questions) {
            if (!isMatch(number, question[0], question[1], question[2])) {
                return false;
            }
        }
        return true;
    }

    static boolean isMatch(int number, int question, int strike, int ball) {
        int[] numDigits = {number / 100, (number / 10) % 10, number % 10};
        int[] questionDigits = {question / 100, (question / 10) % 10, question % 10};

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (numDigits[i] == questionDigits[i]) {
                strikeCount++;
            } else if (numDigits[i] == questionDigits[(i + 1) % 3] || numDigits[i] == questionDigits[(i + 2) % 3]) {
                ballCount++;
            }
        }

        return strikeCount == strike && ballCount == ball;
    }
}
