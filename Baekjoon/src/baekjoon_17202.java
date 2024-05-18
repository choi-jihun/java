import java.io.*;

public class baekjoon_17202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        StringBuilder combined = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            combined.append(a.charAt(i)).append(b.charAt(i));
        }

        String numbers = combined.toString();

        while (numbers.length() > 2) {
            StringBuilder nextNumbers = new StringBuilder();
            for (int i = 0; i < numbers.length() - 1; i++) {
                int sum = (numbers.charAt(i) - '0') + (numbers.charAt(i + 1) - '0');
                nextNumbers.append(sum % 10);
            }
            numbers = nextNumbers.toString();
        }

        bw.write(String.format("%02d", Integer.parseInt(numbers)));
        bw.flush();
    }
}
