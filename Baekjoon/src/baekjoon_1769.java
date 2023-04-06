import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://babocomputer.tistory.com/245 참고

public class baekjoon_1769 {
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int res = Integer.parseInt(Plus(str));
        sb.append(count).append("\n");

        if (res % 3 == 0)
            sb.append("YES");
        else
            sb.append("NO");
        System.out.println(sb);
    }

    private static String Plus(String x) {
        int y = 0;
        char a;
        if (x.length() > 1) {
            for (int i = 0; i < x.length(); i++) {
                a = x.charAt(i);
                y += Integer.parseInt(String.valueOf(a));
            }
            count++;
            return Plus(Integer.toString(y));
        } else
            return x;
    }
}
