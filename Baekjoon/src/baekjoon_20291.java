import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class baekjoon_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            String str = temp.substring(temp.indexOf(".") + 1);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String temp : map.keySet()) {
            sb.append(temp).append(" ").append(map.get(temp)).append("\n");
        }
        System.out.println(sb);
    }
}
