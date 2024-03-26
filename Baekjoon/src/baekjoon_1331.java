import java.io.*;
import java.util.HashSet;

public class baekjoon_1331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        boolean isValid = true;
        HashSet<String> visited = new HashSet<>();

        String currentPos = br.readLine();
        String startPos = currentPos;
        visited.add(currentPos);

        for (int i = 1; i < 36; i++) {
            String nextPos = br.readLine();
            if (!visited.add(nextPos)) {
                isValid = false;
                break;
            }

            int dxPos = nextPos.charAt(0) - currentPos.charAt(0);
            int dyPos = nextPos.charAt(1) - currentPos.charAt(1);
            boolean isMovePossible = false;

            for (int j = 0; j < 8; j++) {
                if (dx[j] == dxPos && dy[j] == dyPos) {
                    isMovePossible = true;
                    break;
                }
            }

            if (!isMovePossible) {
                isValid = false;
                break;
            }

            currentPos = nextPos;
        }

        if (isValid) {
            int dxPos = startPos.charAt(0) - currentPos.charAt(0);
            int dyPos = startPos.charAt(1) - currentPos.charAt(1);
            isValid = false;
            for (int j = 0; j < 8; j++) {
                if (dx[j] == dxPos && dy[j] == dyPos) {
                    isValid = true;
                    break;
                }
            }
        }

        if (isValid) {
            bw.write("Valid");
        } else {
            bw.write("Invalid");
        }
        bw.flush();
    }
}
