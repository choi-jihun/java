import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        int boxCount = 0;
        int currentWeight = 0;

        for (int i = 0; i < N; i++) {
            if (currentWeight + arr[i] <= M) {
                currentWeight += arr[i];
            } else {
                boxCount++;
                currentWeight = arr[i];
            }
        }

        if (currentWeight > 0) {
            boxCount++;
        }

        bw.write(String.valueOf(boxCount));
        bw.flush();
    }
}
