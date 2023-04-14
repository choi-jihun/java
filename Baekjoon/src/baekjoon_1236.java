import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str;
        Boolean[][] arr = new Boolean[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'X')
                    arr[i][j] = true;
                else arr[i][j] = false;
            }

        }
        int rowG = 0;
        int colG = 0;
        Boolean guard;

        for (int i = 0; i < N; i++) {
            guard = false;
            for (int j = 0; j < M; j++)
                if (arr[i][j]) {
                    guard = true;
                    break;
                }

            if (!guard)
                rowG++;
        }
        for (int i = 0; i < M; i++) {
            guard = false;
            for (int j = 0; j < N; j++) {
                if (arr[j][i]) {
                    guard = true;
                    break;
                }
            }
            if (!guard)
                colG++;
        }
        System.out.println(Math.max(rowG, colG));
    }
}
