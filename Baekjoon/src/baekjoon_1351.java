import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class baekjoon_1351 {
    private static HashMap<Long, Long> dp = new HashMap<>();

    public static long find_A(long N, long P, long Q) {
        if (N == 0) return 1;
        if (dp.containsKey(N)) return dp.get(N);
        dp.put(N, find_A(N / P, P, Q) + find_A(N / Q, P, Q));
        return dp.get(N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        dp.put(0L, 1L);
        System.out.println(find_A(N, P, Q));
    }
}
