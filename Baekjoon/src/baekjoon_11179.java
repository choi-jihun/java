import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_11179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        int ans = Integer.parseInt(sb.toString(), 2);
        System.out.println(ans);
    }
}
