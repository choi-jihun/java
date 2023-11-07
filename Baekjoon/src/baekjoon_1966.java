import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1966 {

    static int N, M;
    static Queue<Integer> priQ;
    static Queue<Integer> idxQ;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            priQ = new LinkedList<>();
            idxQ = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                priQ.offer(Integer.parseInt(st.nextToken()));
                idxQ.offer(i);
            }
            printerQue();
        }

        System.out.println(sb);
    }

    static void printerQue() {
        int cnt = 1;
        while (!priQ.isEmpty()) {
            int max = Collections.max(priQ);
            int curPri = priQ.poll();
            int curIdx = idxQ.poll();

            if (max == curPri) {
                if (curIdx == M) {
                    sb.append(cnt).append("\n");
                    return;
                }
                cnt++;
            } else {
                priQ.offer(curPri);
                idxQ.offer(curIdx);
            }
        }
    }
}
