import java.io.*;

public class baekjoon_3085 {

    static char[][] arr;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, checkMaxLength());
                    swap(i, j, i, j + 1);
                }
                if (i < N - 1) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, checkMaxLength());
                    swap(i, j, i + 1, j);
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static int checkMaxLength() {
        int maxLength = 1;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    count++;
                    maxLength = Math.max(maxLength, count);
                } else {
                    count = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    count++;
                    maxLength = Math.max(maxLength, count);
                } else {
                    count = 1;
                }
            }
        }

        return maxLength;
    }
}
