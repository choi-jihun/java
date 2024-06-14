import java.io.*;

public class baekjoon_2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int current = N;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == current) {
                max++;
                current--;
            }
        }

        int result = N - max;
        bw.write(String.valueOf(result));
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }
}
