import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = N - 1;
        int[] koi = new int[2];

        while (start < end) {
            int temp = arr[start] + arr[end];
            if (Math.abs(min) > Math.abs(temp)) {
                min = temp;
                koi[0] = arr[start];
                koi[1] = arr[end];
            }

            if (min == 0)
                break;

            if (temp < 0) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(koi[0] + " " + koi[1]);
        bw.flush();
    }
}
