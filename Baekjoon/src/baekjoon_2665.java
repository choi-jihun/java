import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.LinkedList;
import java.util.Queue;

//코드 참조 https://youngest-programming.tistory.com/538

public class baekjoon_2665 {

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int [][]map;
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0,0,-1,1};
    static int [][]distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        distance = new int[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        BFS();
        System.out.println(distance[n-1][n-1]);
    }

    static void BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        distance[0][0] = 0;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i = 0;i < 4; i++){
                int cur_X = p.x + dx[i];
                int cur_Y = p.y + dy[i];
                if(cur_X >= 0 && cur_X < n && cur_Y >= 0 && cur_Y < n && distance[cur_X][cur_Y] > distance[p.x][p.y]){
                    if(map[cur_X][cur_Y] == 1){
                        distance[cur_X][cur_Y] = distance[p.x][p.y];
                        queue.offer(new Point(cur_X,cur_Y));
                    }
                    else{
                        distance[cur_X][cur_Y] = distance[p.x][p.y] + 1;
                        queue.offer(new Point(cur_X,cur_Y));
                    }
                }
            }
        }
    }


}
