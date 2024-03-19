import java.io.*;
import java.util.PriorityQueue;

public class baekjoon_1715 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("0");
        } else {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                q.offer(Integer.parseInt(br.readLine()));
            }

            while (true) {
                int temp = 0;
                temp = q.poll() + q.poll();
                sum += temp;
                if (q.isEmpty()) {
                    break;
                }
                q.offer(temp);
            }
            bw.write(String.valueOf(sum));
        }
        bw.flush();

    }

}