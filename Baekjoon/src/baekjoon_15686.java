import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_15686 {

    static int N, M;
    static List<List<Integer>> city = new ArrayList<>();
    static List<List<Integer>> homes = new ArrayList<>();
    static List<List<Integer>> chickens = new ArrayList<>();
    static boolean[] open;
    static int minDis = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    List<Integer> home = new ArrayList<>();
                    home.add(i);
                    home.add(j);
                    homes.add(home);
                } else if (value == 2) {
                    List<Integer> chicken = new ArrayList<>();
                    chicken.add(i);
                    chicken.add(j);
                    chickens.add(chicken);
                }
            }
        }

        open = new boolean[chickens.size()];
        calculateChickenDistance(0, 0);
        bw.write(String.valueOf(minDis));
        bw.flush();
    }

    static void calculateChickenDistance(int start, int count) {
        if (count == M) {
            int cityDistance = 0;
            for (List<Integer> home : homes) {
                int distance = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (open[i]) {
                        List<Integer> chicken = chickens.get(i);
                        distance = Math.min(distance, Math.abs(home.get(0) - chicken.get(0)) + Math.abs(home.get(1) - chicken.get(1)));
                    }
                }
                cityDistance += distance;
            }
            minDis = Math.min(minDis, cityDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            open[i] = true;
            calculateChickenDistance(i + 1, count + 1);
            open[i] = false;
        }
    }
}
