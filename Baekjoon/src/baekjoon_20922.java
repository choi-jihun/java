import java.io.*;
import java.util.*;

public class baekjoon_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int start = 0, end = 0, max = 0;

        while (end < N) {
            count[arr[end]]++;

            while (count[arr[end]] > K) {
                count[arr[start]]--;
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
