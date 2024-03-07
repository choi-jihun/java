import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class baekjoon_1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        BigInteger binaryA = new BigInteger(A, 2);
        BigInteger binaryB = new BigInteger(B, 2);

        BigInteger sum = binaryA.add(binaryB);

        String binarySum = sum.toString(2);

        bw.write(binarySum);
        bw.flush();
    }
}
