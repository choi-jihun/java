import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = "CAMBRIDGE".toCharArray();
        String str = br.readLine();

        for (char c : ch) {
            if (str.indexOf(c) > -1)
                str = str.replace(String.valueOf(c), "");
        }
        System.out.println(str);

    }
}
