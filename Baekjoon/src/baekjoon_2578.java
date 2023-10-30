import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2578 {
    static int[][] arr;
    static int cnt;
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int temp = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int x = 0; x < 5; x++)
                        if (arr[k][x] == temp)
                            arr[k][x] = -1;
                }
                col();
                row();
                dia1();
                dia2();

                if (cnt >= 3) {
                    System.out.println(ans);
                    return;
                }
                cnt = 0;
                ans++;
            }
        }
    }

    static void col() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == -1)
                    count++;
                if (count == 5)
                    cnt++;
            }
        }
    }

    static void row() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == -1)
                    count++;
                if (count == 5)
                    cnt++;
            }
        }
    }

    static void dia1() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] == -1)
                count++;
            if (count == 5)
                cnt++;
        }
    }

    static void dia2() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == -1)
                count++;
            if (count == 5)
                cnt++;
        }
    }
}
