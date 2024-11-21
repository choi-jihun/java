import java.io.*;
import java.util.*;

public class baekjoon_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int target : targets) {
            int targetIndex = deque.indexOf(target);
            int leftShift = targetIndex;
            int rightShift = deque.size() - targetIndex;

            if (leftShift <= rightShift) {
                count += leftShift;
                for (int i = 0; i < leftShift; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                count += rightShift;
                for (int i = 0; i < rightShift; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }

            deque.pollFirst();
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}
