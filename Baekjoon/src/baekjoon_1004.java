import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            cnt = 0;

            int num = Integer.parseInt(br.readLine());
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                int cX = Integer.parseInt(st.nextToken());
                int cY = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean startPass = Passed(startX, startY, cX, cY, r);
                boolean endPass = Passed(endX, endY, cX, cY, r);

                if (!(startPass && endPass) && (startPass || endPass))
                    cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static boolean Passed(int xo, int yo, int x, int y, int r) {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < r;
    }
}
