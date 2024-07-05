import java.io.*;

public class baekjoon_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 3; i > 0; i--){
            String s = br.readLine();
            if(s.matches("-?\\d+(\\.\\d+)?")){
                int n = Integer.parseInt(s) + i;
                if (n % 15 == 0) {
                    bw.write("FizzBuzz\n");
                } else if (n % 3 == 0) {
                    bw.write("Fizz\n");
                } else if (n % 5 == 0) {
                    bw.write("Buzz\n");
                } else {
                    bw.write(n + "\n");
                }
                bw.flush();
                return;
            }
        }
        br.close();
        bw.close();
    }
}
