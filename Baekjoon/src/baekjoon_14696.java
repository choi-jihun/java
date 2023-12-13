import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] countA = new int[5];
            int[] countB = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                countA[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                countB[Integer.parseInt(st.nextToken())]++;
            }

            String result = "D";
            for (int j = 4; j > 0; j--) {
                if (countA[j] > countB[j]) {
                    result = "A";
                    break;
                } else if (countA[j] < countB[j]) {
                    result = "B";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
