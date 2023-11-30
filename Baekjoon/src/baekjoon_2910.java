import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> firstAppearanceMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            firstAppearanceMap.putIfAbsent(num, i);
        }

        ArrayList<Integer> list = new ArrayList<>(freqMap.keySet());
        list.sort((a, b) -> {
            if (freqMap.get(a).equals(freqMap.get(b))) {
                return Integer.compare(firstAppearanceMap.get(a), firstAppearanceMap.get(b));
            }
            return Integer.compare(freqMap.get(b), freqMap.get(a));
        });

        for (Integer element : list) {
            for (int i = 0; i < freqMap.get(element); i++) {
                sb.append(element).append(" ");
            }
        }
        System.out.println(sb);
    }
}
