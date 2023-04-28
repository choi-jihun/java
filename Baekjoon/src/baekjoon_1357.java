import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = st.nextToken();
        String Y = st.nextToken();

        int x = Rev(Integer.parseInt(X));
        int y = Rev(Integer.parseInt(Y));
        int sum = Rev(x + y);

        System.out.println(sum);
    }

    static int Rev(int N) {
        StringBuilder str = new StringBuilder();
        while (N > 0) {
            str.append(N % 10);
            N /= 10;
        }
        return Integer.parseInt(str.toString());
    }
}
