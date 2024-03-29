import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int minSum = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int small = 0, big = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (minSum > Math.abs(sum)) {
                minSum = Math.abs(sum);
                small = left;
                big = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(arr[small] + " " + arr[big]);
    }
}
