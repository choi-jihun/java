import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String next = br.readLine();
            char[] k_pos = king.clone();
            char[] s_pos = stone.clone();
            move(next, k_pos);
            if (range(k_pos)) {
                continue;
            }
            if (Arrays.equals(k_pos, s_pos)) {
                move(next, s_pos);
                if (range(s_pos)) {
                    continue;
                }
            }
            king = k_pos;
            stone = s_pos;
        }

        System.out.println(king);
        System.out.println(stone);

    }

    static boolean range(char[] next) {
        return (next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8');
    }

    static void move(String dir, char[] next) {
        switch (dir) {
            case "R":
                next[0]++;
                break;
            case "L":
                next[0]--;
                break;
            case "B":
                next[1]--;
                break;
            case "T":
                next[1]++;
                break;
            case "RT":
                next[0]++;
                next[1]++;
                break;
            case "LT":
                next[0]--;
                next[1]++;
                break;
            case "RB":
                next[0]++;
                next[1]--;
                break;
            case "LB":
                next[0]--;
                next[1]--;
                break;
        }
    }

}