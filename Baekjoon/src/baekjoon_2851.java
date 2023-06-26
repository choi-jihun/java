import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int cmp = 0;
        int temp = 100;

        for (int i = 0; i < 10; i++) {
            cmp += Integer.parseInt(br.readLine());
            if (Math.abs(100 - cmp) <= temp) {
                temp = Math.abs(100 - cmp);
                ans = cmp;
            }
        }

        System.out.println(ans);
    }
}
