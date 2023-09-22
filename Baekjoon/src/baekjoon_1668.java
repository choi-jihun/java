import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int leftCnt = 1;
        int rightCnt = 1;
        int leftMax = arr[0];
        int rightMax = arr[N - 1];

        for (int i = 1; i < N; i++) {
            if (leftMax < arr[i]) {
                leftMax = arr[i];
                leftCnt++;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if (rightMax < arr[i]) {
                rightMax = arr[i];
                rightCnt++;
            }
        }
        System.out.println(leftCnt);
        System.out.println(rightCnt);
    }
}
