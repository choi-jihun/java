import java.io.*;
import java.util.StringTokenizer;


//핵심 알고리즘은 x->y로 가는 방향이 바뀔때마다 비율 위치 배열이 달라진다
//시간복잡도는 n*n
//처음에는 비율이 저 좌표에 고정된 건 줄 알아서 좀 헤맸음
//39984KB, 432ms
public class baekjoon_20057 {
    static int[][] sand;
    static int N, result = 0;
    //토네이도 이동 방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    //⭐ 비율 위치 배열 4개인 이유는 x->y로 가는게 방향이 변하기 때문 ⭐
    static int[][] spreadX = {{-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1}, {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}};
    static int[][] spreadY = {{1, 1, 0, 0, 0, 0, -1, -1, -2, -1}, {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1}, {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}};
    static int[] spreadPercent = {1, 1, 2, 2, 7, 7, 10, 10, 5, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sand = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sand[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveTornado();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void moveTornado() {
        //토네이도 시작 위치
        int x = N / 2;
        int y = N / 2;
        //초기 이동 방향 왼쪽
        int direction = 0;
        //이동 거리
        int length = 1;

        while (true) {
            //각 바향마다 두 번 이동
            for (int i = 0; i < 2; i++) {
                //이동 거리 만큼 이동
                for (int j = 0; j < length; j++) {
                    //0,0 도달 시 종료
                    if (x == 0 && y == 0)
                        return;

                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    spreadSand(nx, ny, direction);

                    x = nx;
                    y = ny;
                }
                direction = (direction + 1) % 4;
            }
            length++;
        }
    }

    private static void spreadSand(int x, int y, int direction) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return;

        //현재 모래양
        int total = sand[x][y];
        //a 위치로 이동할 모래 양 계산 할 잔여 모래 양
        int remain = total;

        //a 포함 10개 칸에서 모래 이동
        for (int i = 0; i < 10; i++) {
            //마지막 남은 모래는 a로 이동
            int amount = (i == 9) ? remain : (total * spreadPercent[i] / 100);
            int nx = x + spreadX[direction][i];
            int ny = y + spreadY[direction][i];

            //배열 안이면 모래 이동
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                sand[nx][ny] += amount;
            }
            //배열 밖이면 결과에 추가
            else {
                result += amount;
            }

            remain -= amount;
        }

        sand[x][y] = 0;
    }
}
