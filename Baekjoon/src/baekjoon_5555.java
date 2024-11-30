import java.io.*;

public class baekjoon_5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String ring = br.readLine();
            String doubledRing = ring + ring;

            if (doubledRing.contains(target)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }
}
