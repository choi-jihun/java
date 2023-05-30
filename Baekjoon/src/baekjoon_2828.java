import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = left + M - 1;

        int j = Integer.parseInt(br.readLine());

        int dis = 0;
        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine()) - 1;
            if (apple < left) {
                int diff = left - apple;
                dis += diff;
                left -= diff;
                right -= diff;
            } else if (apple > right) {
                int diff = apple - right;
                dis += diff;
                right += diff;
                left += diff;
            }
        }

        System.out.println(dis);
    }
}
