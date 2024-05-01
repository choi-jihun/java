import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            total += arr[i];
        }

        int left = max;
        int right = total;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPartition(arr, N, M, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }

    private static boolean canPartition(int[] arr, int N, int M, int maxLen) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > maxLen) {
                count++;
                sum = arr[i];
                if (count > M) {
                    return false;
                }
            } else {
                sum += arr[i];
            }
        }
        return true;
    }
}
