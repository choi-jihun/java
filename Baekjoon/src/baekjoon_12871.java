import java.io.*;

public class baekjoon_12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        int lenS = s.length();
        int lenT = t.length();

        int lcmLength = lcm(lenS, lenT);

        StringBuilder repeatedS = new StringBuilder();
        StringBuilder repeatedT = new StringBuilder();

        for (int i = 0; i < lcmLength / lenS; i++) {
            repeatedS.append(s);
        }

        for (int i = 0; i < lcmLength / lenT; i++) {
            repeatedT.append(t);
        }

        if (repeatedS.toString().contentEquals(repeatedT)) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
