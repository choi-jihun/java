import java.io.*;

public class baekjoon_1992 {
    private static char[][] arr;
    private static int N;

    private static boolean isUniform(int x, int y, int size) {
        char first = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
    private static String compress(int x, int y, int size) {
        if (isUniform(x, y, size)) {
            return String.valueOf(arr[x][y]);
        } else {
            int newSize = size / 2;
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(compress(x, y, newSize));
            sb.append(compress(x, y + newSize, newSize));
            sb.append(compress(x + newSize, y, newSize));
            sb.append(compress(x + newSize, y + newSize, newSize));
            sb.append(")");
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        String result = compress(0, 0, N);
        bw.write(result);
        bw.flush();
    }
}
