import java.io.*;
import java.util.*;

public class baekjoon_2174 {

    static class Robot {
        int x, y;
        char direction;

        public Robot(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int A, B;
    static Robot[] robots;
    static int[][] arr;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static final Map<Character, Integer> directionMap = new HashMap<>();
    static {
        directionMap.put('N', 0);
        directionMap.put('E', 1);
        directionMap.put('S', 2);
        directionMap.put('W', 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        robots = new Robot[N + 1];
        arr = new int[A + 1][B + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            robots[i] = new Robot(x, y, direction);
            arr[x][y] = i;
        }

        boolean isCrash = false;
        for (int i = 0; i < M && !isCrash; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            for (int j = 0; j < repeat && !isCrash; j++) {
                isCrash = executeCommand(robotNum, command, bw);
            }
        }

        if (!isCrash) {
            bw.write("OK\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean executeCommand(int robotNum, char command, BufferedWriter bw) throws IOException {
        Robot robot = robots[robotNum];
        int dirIndex = directionMap.get(robot.direction);

        switch (command) {
            case 'L':
                dirIndex = (dirIndex + 3) % 4;
                robot.direction = getDirection(dirIndex);
                break;
            case 'R':
                dirIndex = (dirIndex + 1) % 4;
                robot.direction = getDirection(dirIndex);
                break;
            case 'F':
                int nx = robot.x + dx[dirIndex];
                int ny = robot.y + dy[dirIndex];

                if (nx < 1 || nx > A || ny < 1 || ny > B) {
                    bw.write("Robot " + robotNum + " crashes into the wall\n");
                    return true;
                }

                if (arr[nx][ny] != 0) {
                    bw.write("Robot " + robotNum + " crashes into robot " + arr[nx][ny] + "\n");
                    return true;
                }

                arr[robot.x][robot.y] = 0;
                arr[nx][ny] = robotNum;
                robot.x = nx;
                robot.y = ny;
                break;
        }

        return false;
    }

    static char getDirection(int index) {
        char[] directions = {'N', 'E', 'S', 'W'};
        return directions[index];
    }
}
