import java.io.*;

public class baekjoon_15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        char[] ucpc = {'U', 'C', 'P', 'C'};
        int currentIndex = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ucpc[currentIndex]) {
                currentIndex++;
                if(currentIndex == 4) break;
            }
        }

        if(currentIndex == 4) {
            bw.write("I love UCPC");
        } else {
            bw.write("I hate UCPC");
        }
        bw.flush();
    }
}
