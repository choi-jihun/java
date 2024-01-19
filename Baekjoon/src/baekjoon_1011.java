import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1011 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = y - x;
            int max = (int) Math.sqrt(dist);

            if (max == Math.sqrt(dist)) {
                sb.append(2 * max - 1).append("\n");
            } else if (dist <= max * max + max) {
                sb.append(2 * max).append("\n");
            } else {
                sb.append(2 * max + 1).append("\n");
            }
        }
        System.out.println(sb);
    }

}
