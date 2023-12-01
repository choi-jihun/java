import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        ArrayList<String> words = new ArrayList<>(map.keySet());

        words.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return map.get(o2) - map.get(o1);
        });

        for (String temp : words) {
            sb.append(temp).append("\n");
        }

        System.out.println(sb);
    }
}
