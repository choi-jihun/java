import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_9375 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                if (map.containsKey(category)) {
                    map.put(category, map.get(category) + 1);
                } else {
                    map.put(category, 1);
                }
            }
            int result = 1;
            for (int val : map.values()) {
                result *= (val + 1);
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }

}