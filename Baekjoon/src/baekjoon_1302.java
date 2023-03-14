import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class baekjoon_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (map.containsKey(str))
                map.replace(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        int max = 0;
        for (String s : map.keySet())
            max = Math.max(max, map.get(s));
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);
        for (String s : arr) {
            if (map.get(s) == max) {
                System.out.println(s);
                break;
            }
        }
    }
}
