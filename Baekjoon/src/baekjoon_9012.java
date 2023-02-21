import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9012 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0)
            sb.append(answer(br.readLine())).append("\n");

        System.out.println(sb);

    }

    static String answer(String str) {
        int cnt = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(')
                cnt++;

            else if (cnt == 0)
                return "NO";

            else cnt--;
        }
        if (cnt == 0)
            return "YES";
        else
            return "NO";

    }
}
