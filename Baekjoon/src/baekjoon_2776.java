import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                map.put(Integer.parseInt(st.nextToken()), 0);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (map.containsKey(temp))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
