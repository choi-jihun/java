import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class baekjoon_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if (temp.equals("ENTER")) {
                cnt += set.size();
                set = new HashSet<>();
            } else {
                set.add(temp);
            }
        }
        cnt += set.size();
        System.out.println(cnt);
    }
}
