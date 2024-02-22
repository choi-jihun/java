import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_1058 {

    static int[][] dist;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else {
                    dist[i][j] = (str.charAt(j) == 'Y') ? 1 : 100000000;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int maxTwoFriends = 0;
        for (int i = 0; i < N; i++) {
            int twoFriendsCount = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && dist[i][j] <= 2) {
                    twoFriendsCount++;
                }
            }
            maxTwoFriends = Math.max(maxTwoFriends, twoFriendsCount);
        }

        bw.write(maxTwoFriends + "");
        bw.flush();
    }

}
