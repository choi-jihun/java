import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        double sum = 0;
        double score_sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double temp = 0;
            String str = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            String grade = st.nextToken();

            if (grade.length() >= 1) {
                if (grade.charAt(0) == 'A') temp = 4;
                if (grade.charAt(0) == 'B') temp = 3;
                if (grade.charAt(0) == 'C') temp = 2;
                if (grade.charAt(0) == 'D') temp = 1;
            }

            if (grade.length() >= 2) {
                if (grade.charAt(1) == '+') temp += 0.3;
                if (grade.charAt(1) == '-') temp -= 0.3;
            }

            score_sum += score;
            sum += temp * score;
        }

        System.out.println(String.format("%.2f", sum / score_sum));

    }
}
