import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int maxDigit = -1, winner = -1;
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] cards = new int[5];
            for (int j = 0; j < 5; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }

            int maxForPlayer = findMaxDigitSum(cards);
            if (maxForPlayer >= maxDigit) {
                maxDigit = maxForPlayer;
                winner = i;
            }
        }

        bw.write(String.valueOf(winner));
        bw.flush();
    }

    private static int findMaxDigitSum(int[] cards) {
        int max = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    int digitSum = sum % 10;
                    max = Math.max(max, digitSum);
                }
            }
        }
        return max;
    }
}
