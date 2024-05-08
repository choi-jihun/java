import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_2737 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            if (N < 3) {
                bw.write("0\n");
                continue;
            }

            int tempN = N - 1;
            for (int i = 2; i <= tempN; i++) {
                tempN -= i;
                if (tempN < 0) {
                    break;
                }
                count += (tempN % i == 0) ? 1 : 0;
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }

}
