import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1806{

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if (min != Integer.MAX_VALUE) {
            bw.write(String.valueOf(min));
        } else {
            bw.write("0");
        }

        bw.flush();
    }

}
