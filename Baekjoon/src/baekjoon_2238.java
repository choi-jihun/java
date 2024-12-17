import java.io.*;
import java.util.*;

public class baekjoon_2238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> priceCount = new HashMap<>();
        Map<Integer, String> priceFirstPerson = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
            priceFirstPerson.putIfAbsent(price, name);
        }

        int minCount = Integer.MAX_VALUE;
        for (int count : priceCount.values()) {
            minCount = Math.min(minCount, count);
        }

        int minPrice = Integer.MAX_VALUE;
        for (int price : priceCount.keySet()) {
            if (priceCount.get(price) == minCount) {
                minPrice = Math.min(minPrice, price);
            }
        }

        String winner = priceFirstPerson.get(minPrice);
        bw.write(winner + " " + minPrice + "\n");
        bw.flush();
        bw.close();
    }
}
