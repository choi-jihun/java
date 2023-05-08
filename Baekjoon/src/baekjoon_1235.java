import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class baekjoon_1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String[] str = new String[N];

        for (int i = 0; i < N; i++)
            str[i] = br.readLine();

        for (int i = 1; i <= str[0].length(); i++) {
            for (int j = 0; j < N; j++)
                set.add(str[j].substring(str[0].length() - i));
            if (set.size() == N) {
                System.out.println(i);
                return;
            }
            set.clear();
        }
    }
}
