import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10026 {
    //색약은 G랑 R 구분 못함
    static char [][]arr;
    static boolean [][]visited;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char [n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++)
                arr[i][j] = str.charAt(j);
        }

        int normal_cnt = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                if(!visited[i][j]){
                    dfs(i,j);
                    normal_cnt++;
                }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (arr[i][j] == 'G')
                    arr[i][j] = 'R';
        }

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
        }
        System.out.println(normal_cnt + " " + cnt);


    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        char tmp = arr[x][y];
        for(int i = 0; i < 4; i++){
            int cur_x = x + dx[i];
            int cur_y = y + dy[i];
            if(cur_x >= 0 && cur_y >= 0 && cur_x < n && cur_y < n && !visited[cur_x][cur_y] && tmp == arr[cur_x][cur_y])
                dfs(cur_x,cur_y);
        }
    }
}
