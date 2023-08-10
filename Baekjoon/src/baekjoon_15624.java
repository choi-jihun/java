import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class baekjoon_15624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[1000001];
        BigInteger modValue = BigInteger.valueOf(1000000007);
        if (n < 2)
            System.out.println(n);
        else {
            arr[0] = BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            for (int i = 2; i < n + 1; i++)
                arr[i] = arr[i - 2].add(arr[i - 1]).mod(modValue);;
            System.out.println(arr[n]);
        }
    }
}
