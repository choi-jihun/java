import java.io.*;

public class baekjoon_10823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            sb.append(line);
        }

        String str = sb.toString();

        String[] numbers = str.split(",");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
