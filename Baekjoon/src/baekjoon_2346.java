import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            bw.write(current[0] + " ");

            if (deque.isEmpty()) {
                break;
            }

            if (current[1] > 0) {
                for (int i = 1; i < current[1]; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(current[1]); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        bw.flush();
    }
}
