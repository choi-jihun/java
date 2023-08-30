import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baekjoon_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        int max = 0;
        long ans = 0;

        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Long i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                ans = i;
            } else if (map.get(i) == max) {
                ans = Math.min(ans, i);
            }
        }

        System.out.println(ans);

    }
}
