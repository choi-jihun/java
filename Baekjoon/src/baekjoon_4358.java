import java.io.*;
import java.util.*;


public class baekjoon_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        int totalTrees = 0;
        String str;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            totalTrees++;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String species : list) {
            double percentage = (map.get(species) * 100.0) / totalTrees;
            bw.write(String.format("%s %.4f%n", species, percentage));
        }

        bw.flush();
    }
}
