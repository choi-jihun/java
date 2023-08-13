import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            char ch = str.charAt(i);
            if (ch == 'S')
                cnt++;
            else if (ch == 'L') {
                i++;
                cnt++;
            }
        }
        if (cnt > N)
            System.out.println(N);
        else
            System.out.println(cnt);
    }
}
