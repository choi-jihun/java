import java.io.*;

public class baekjoon_2684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());

        String[] sequences = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};

        for (int i = 0; i < P; i++) {
            String str = br.readLine();
            int[] counts = new int[8];

            for (int j = 0; j <= 37; j++) {
                String subSeq = str.substring(j, j + 3);
                for (int k = 0; k < sequences.length; k++) {
                    if (subSeq.equals(sequences[k])) {
                        counts[k]++;
                        break;
                    }
                }
            }

            for (int j = 0; j < counts.length; j++) {
                bw.write(counts[j] + (j < counts.length - 1 ? " " : "\n"));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
