import java.io.*;
import java.util.*;

public class baekjoon_11479 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] arrange = new int[N];

            int left = 0;
            int right = N - 1;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    arrange[left++] = arr[i];
                } else {
                    arrange[right--] = arr[i];
                }
            }

            int minDiff = 0;
            for (int i = 1; i < N; i++) {
                minDiff = Math.max(minDiff, Math.abs(arrange[i] - arrange[i - 1]));
            }
            minDiff = Math.max(minDiff, Math.abs(arrange[0] - arrange[N - 1]));

            bw.write(minDiff + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
