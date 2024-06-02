import java.io.*;
import java.util.*;

public class baekjoon_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for (int i = 0; i < 7; i++) {
            stack[i] = new Stack<>();
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!stack[line].isEmpty() && stack[line].peek() > fret) {
                stack[line].pop();
                cnt++;
            }

            if (!stack[line].isEmpty() && stack[line].peek() == fret) {
                continue;
            }

            stack[line].push(fret);
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
