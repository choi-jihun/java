import java.io.*;
import java.util.*;

public class baekjoon_2792 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        long max = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long left = 1;
        long right = max;
        long result = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canDistribute(arr, N, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canDistribute(int[] arr, int N, long max) {
        long students = 0;

        for (int jewel : arr) {
            students += (jewel + max - 1) / max;
            if (students > N) {
                return false;
            }
        }

        return students <= N;
    }
}
