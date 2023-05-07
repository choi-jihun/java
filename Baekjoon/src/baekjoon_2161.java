import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++)
            que.add(i);

        while (que.size() != 1) {
            sb.append(que.poll()).append(" ");
            que.add(que.poll());
        }
        sb.append(que.poll());
        System.out.println(sb);
    }
}
