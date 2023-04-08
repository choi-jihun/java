import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while (true) {
            str = br.readLine();
            boolean check = true;
            if (str.equals("0"))
                break;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                    check = false;
            }
            if (check)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
