import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_20056 {
    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Fireball>[][] map;

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            moveFireballs();
            mergeAndDivideFireballs();
        }

        bw.write(String.valueOf(getTotalMass()));
        bw.flush();
    }

    static void moveFireballs() {
        ArrayList<Fireball>[][] newMap = new ArrayList[N][N]; //파이어 불 이동 후 상태 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = new ArrayList<>(); // 초기화
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (Fireball fireball : map[r][c]) {
                    int nr = (fireball.r + dr[fireball.d] * fireball.s % N + N) % N; // 이동 후 행 위치
                    int nc = (fireball.c + dc[fireball.d] * fireball.s % N + N) % N; // 이동 후 열 위치
                    newMap[nr][nc].add(new Fireball(nr, nc, fireball.m, fireball.s, fireball.d));
                }
            }
        }

        map = newMap; //업데이트
    }

    static void mergeAndDivideFireballs() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() > 1) { //파이어 볼 2개 이상이면
                    int sumM = 0;
                    int sumS = 0;
                    boolean even = true;
                    boolean odd = true;
                    for (Fireball fireball : map[r][c]) {
                        sumM += fireball.m;
                        sumS += fireball.s;
                        if (fireball.d % 2 == 0)
                            odd = false;
                        else
                            even = false;
                    }

                    int count = map[r][c].size();
                    int nm = sumM / 5;
                    int ns = sumS / count;
                    map[r][c].clear();
                    if (nm > 0) {
                        for (int i = 0; i < 4; i++) {
                            int nd = (even || odd) ? i * 2 : i * 2 + 1;
                            map[r][c].add(new Fireball(r, c, nm, ns, nd));
                        }
                    }
                }
            }
        }
    }

    static int getTotalMass() {
        int totalMass = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (Fireball fireball : map[r][c]) {
                    totalMass += fireball.m;
                }
            }
        }
        return totalMass;
    }
}
