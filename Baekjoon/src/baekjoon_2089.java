import java.io.*;

public class baekjoon_2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            bw.write("0");
        } else {
            StringBuilder result = new StringBuilder();
            while (N != 0) {
                int remainder = N % -2;
                N /= -2;

                if (remainder < 0) {
                    remainder += 2;
                    N += 1;
                }

                result.append(remainder);
            }
            result.reverse();
            bw.write(result.toString());
        }

        bw.flush();
    }
}
