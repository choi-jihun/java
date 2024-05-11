import java.io.*;

public class baekjoon_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        int x = 1, y = 1;
        boolean found = false;

        while (x - y > 1 || (long)x * x - (long)y * y <= G) {
            long current = (long)x * x - (long)y * y;
            if (current == G) {
                found = true;
                bw.write(x + "\n");
            }
            if (current > G) {
                y++;
            } else {
                x++;
            }
        }

        if (!found) {
            bw.write("-1\n");
        }

        bw.flush();
    }
}
