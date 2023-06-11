import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int num = 1;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (K-- > 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int gap = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] > max)
                    max = arr[i];
                if (min > arr[i])
                    min = arr[i];
            }
            Arrays.sort(arr, Collections.reverseOrder());
            for (int i = 1; i < N; i++) {
                int i1 = arr[i - 1] - arr[i];
                if (i1 > gap)
                    gap = i1;
            }
            sb.append("Class ").append(num).append("\n").append("Max ").append(max).append(", Min ").append(min).append(", Largest gap ").append(gap).append("\n");
            num++;
        }
        System.out.println(sb);

    }
}
