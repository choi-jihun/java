import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] ch = new char[5][15];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] != '\0') {
                    sb.append(ch[j][i]);
                }
            }
        }

        System.out.print(sb);
    }
}
