import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int dasom = Integer.parseInt(br.readLine());
        int[] arr = new int[N - 1];
        for (int i = 0; i < N - 1; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (true) {
            Arrays.sort(arr);
            if (arr[N - 2] < dasom) break;
            cnt++;
            arr[N - 2]--;
            dasom++;
        }

        System.out.println(cnt);
    }
}
