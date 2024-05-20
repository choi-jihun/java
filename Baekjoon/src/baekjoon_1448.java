import java.io.*;
import java.util.Arrays;

public class baekjoon_1448 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = -1;

        for (int i = N - 1; i >= 2; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                max = arr[i] + arr[i - 1] + arr[i - 2];
                break;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
