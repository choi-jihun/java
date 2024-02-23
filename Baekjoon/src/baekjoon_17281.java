import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_17281 {

    static int[][] arr;
    static int inning, score;
    static int[] base;
    static int[] lineUp;
    static boolean[] isUsed;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        inning = Integer.parseInt(br.readLine());
        arr = new int[inning][9];
        lineUp = new int[9];
        isUsed = new boolean[9];

        lineUp[3] = 0;
        isUsed[3] = true;

        base = new int[4];
        score = 0;

        for (int i = 0; i < inning; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeLineup(1);
        bw.write(score + "");
        bw.flush();
    }

    static void startGame() {
        int out = 0;
        int cnt = 0;
        int leadOff = 0;

        for (int in = 0; in < inning; in++) {
            base = new int[4];
            out = 0;
            outer: for (int i = leadOff; i < 9; i++) {
                if (arr[in][lineUp[i]] != 0) {
                    for (int j = 3; j >= 1; j--) {
                        if (base[j] == 1 && arr[in][lineUp[i]] + j >= 4) {
                            cnt++;
                            base[j] = 0;
                        } else if (base[j] == 1 && arr[in][lineUp[i]] + j < 4) {
                            base[j] = 0;
                            base[j + arr[in][lineUp[i]]] = 1;
                        }
                    }
                    if (arr[in][lineUp[i]] == 4) {
                        cnt++;
                    } else {
                        base[arr[in][lineUp[i]]] = 1;
                    }
                } else {
                    out++;
                }
                if (i == 8 && out < 3) {
                    leadOff = 0;
                    i = leadOff - 1;
                }
                if (out == 3) {
                    leadOff = (i + 1) % 9;
                    break outer;
                }
            }
        }

        score = Math.max(cnt, score);
    }

    static void makeLineup(int idx) {
        if (idx == 9) {
            startGame();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                lineUp[i] = idx;
                makeLineup(idx + 1);
                isUsed[i] = false;
            }
        }
    }

}
