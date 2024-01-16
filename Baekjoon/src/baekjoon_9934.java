import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9934 {
    static int K;
    static int[] arr;
    static StringBuilder[] sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        arr = new int[(int) (Math.pow(2, K) - 1)];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            sb[i] = new StringBuilder();
        }
        recursive(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            System.out.println(sb[i]);
        }
    }

    static void recursive(int start, int end, int floor) {
        if (floor == K) {
            return;
        }

        int mid = (start + end) / 2;
        sb[floor].append(arr[mid]).append(" ");

        recursive(start, mid - 1, floor + 1);
        recursive(mid + 1, end, floor + 1);
    }
}
