import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (P == 0 && L == 0 && V == 0)
                break;

            int i = V / P;
            int sum = i * L;
            sum += Math.min(V % P, L);
            num++;
            sb.append("Case ").append(num).append(": ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
