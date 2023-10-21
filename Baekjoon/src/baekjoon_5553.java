import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_5553 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                boolean unique = true;
                for (int k = 0; k < N; k++) {
                    if (j != k && arr[j][i] == arr[k][i]) {
                        unique = false;
                        break;
                    }
                }
                if (unique)
                    sum[j] += arr[j][i];
            }
        }

        for (int i = 0; i < N; i++)
            System.out.println(sum[i]);
    }
}
