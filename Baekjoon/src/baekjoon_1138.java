import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 1; i < N + 1; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (cnt == 0 && arr[j] == 0) {
                    arr[j] = i;
                    break;
                } else if (arr[j] == 0)
                    cnt--;
            }
        }
        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " ");

    }
}
