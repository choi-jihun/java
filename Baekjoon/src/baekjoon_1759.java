import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1759 {

    static char str[];
    static boolean visited[];
    static int L,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        str = new char [C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < str.length; i++){
            String s = st.nextToken();
            str[i] = s.charAt(0);
        }

        Arrays.sort(str);
        dfs(0,0);
    }

    static void dfs(int start, int depth){
        if(depth == L){
            int vowel = 0;
            int con = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < C; i++){
                if(visited[i]){
                    sb.append(str[i]);
                    if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
                        vowel++;
                    else
                        con++;
                }
            }
            if(vowel>=1 && con >=2)
                System.out.println(sb);
        }
        for(int i = start; i < C; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
