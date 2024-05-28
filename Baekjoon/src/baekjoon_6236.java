import java.io.*;
import java.util.*;

public class baekjoon_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int low = 0;
        int high = Integer.MAX_VALUE;
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, N, M, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPossible(int[] expenses, int N, int M, int K) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (expenses[i] > K)
                return false;
            if (sum + expenses[i] > K) {
                count++;
                sum = expenses[i];
                if (count > M)
                    return false;
            } else {
                sum += expenses[i];
            }
        }

        return true;
    }
}
