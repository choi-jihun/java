import java.io.*;

public class baekjoon_1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int injured = Integer.parseInt(br.readLine());
        long max = Long.parseLong(br.readLine());

        long result;

        if (injured == 1) {
            result = max * 8;
        } else if (injured == 2) {
            result = 1 + (max / 2) * 8 + (max % 2) * 6;
        } else if (injured == 3) {
            result = 2 + (max / 2) * 8 + (max % 2) * 4;
        } else if (injured == 4) {
            result = 3 + (max / 2) * 8 + (max % 2) * 2;
        } else {
            result = 4 + max * 8;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
