import java.io.*;
import java.util.*;

public class baekjoon_16198 {
    static int maxEnergy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> beads = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            beads.add(Integer.parseInt(st.nextToken()));
        }

        collectEnergy(beads, 0);

        bw.write(maxEnergy + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void collectEnergy(List<Integer> beads, int energy) {
        if (beads.size() == 2) {
            maxEnergy = Math.max(maxEnergy, energy);
            return;
        }

        for (int i = 1; i < beads.size() - 1; i++) {
            int collectedEnergy = beads.get(i - 1) * beads.get(i + 1);

            int removed = beads.remove(i);
            collectEnergy(beads, energy + collectedEnergy);
            beads.add(i, removed);
        }
    }
}
