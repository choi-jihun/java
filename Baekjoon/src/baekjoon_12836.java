import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_12836 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            long change = Long.parseLong(st.nextToken());

            if (temp == 1) {
                arr[day] += change;
            } else {
                long sum = 0;
                for (int i = day; i <= change; i++) {
                    sum += arr[i];
                }
                bw.write(sum + "\n");
            }
        }
        bw.flush();
    }

}