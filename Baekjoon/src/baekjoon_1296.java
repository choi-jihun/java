import java.io.*;

public class baekjoon_1296 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        int N = Integer.parseInt(br.readLine());

        String[] team = new String[N];

        for (int i = 0; i < N; i++) {
            team[i] = br.readLine();
        }

        int maxScore = -1;
        String bestTeam = "";

        for (String teamName : team) {
            String combined = name + teamName;
            int L = countChar(combined, 'L');
            int O = countChar(combined, 'O');
            int V = countChar(combined, 'V');
            int E = countChar(combined, 'E');

            int score = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;

            if (score > maxScore || (score == maxScore && teamName.compareTo(bestTeam) < 0)) {
                maxScore = score;
                bestTeam = teamName;
            }
        }

        bw.write(bestTeam);
        bw.flush();
    }

    private static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
