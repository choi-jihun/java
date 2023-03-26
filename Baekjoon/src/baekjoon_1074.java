import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1074 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2, N);

        recursive(length, r, c);
        System.out.println(cnt);
    }

    static void recursive(int length, int r, int c) {
        if (length == 1)
            return;
        if (r < length / 2 && c < length / 2) {
            recursive(length / 2, r, c);
        } else if (r < length / 2 && c >= length / 2) {
            cnt += length * length / 4;
            recursive(length / 2, r, c - length / 2);
        } else if (r >= length / 2 && c < length / 2) {
            cnt += (length * length / 4) * 2;
            recursive(length / 2, r - length / 2, c);
        } else {
            cnt += (length * length / 4) * 3;
            recursive(length / 2, r - length / 2, c - length / 2);
        }
    }
}
