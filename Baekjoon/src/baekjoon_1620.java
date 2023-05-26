import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }


        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (isNumber(str))
                sb.append(arr[Integer.parseInt(str)]).append("\n");
            else
                sb.append(map.get(str)).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
