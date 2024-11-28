import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class baekjoon_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<BigInteger> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Matcher matcher = Pattern.compile("\\d+").matcher(line);

            while (matcher.find()) {
                String numStr = matcher.group();
                numbers.add(new BigInteger(numStr));
            }
        }

        numbers.sort(null);

        for (BigInteger num : numbers) {
            bw.write(num.toString() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
