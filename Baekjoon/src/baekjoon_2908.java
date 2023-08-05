import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder(st.nextToken());
        String reverse = sb.reverse().toString();
        sb = new StringBuilder(st.nextToken());
        String reverse2 = sb.reverse().toString();

        reverse = Integer.parseInt(reverse) > Integer.parseInt(reverse2) ? reverse : reverse2;

        System.out.println(reverse);
    }
}
