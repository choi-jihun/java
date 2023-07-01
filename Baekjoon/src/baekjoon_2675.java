import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();
            for (int j = 0; j < temp.length(); j++) {
                for (int k = 0; k < R; k++)
                    sb.append(temp.charAt(j));
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
