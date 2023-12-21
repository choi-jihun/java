import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_16466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> soldTickets = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int ticketNumber = Integer.parseInt(st.nextToken());
            soldTickets.add(ticketNumber);
        }

        int ticketToBuy = 1;
        while (soldTickets.contains(ticketToBuy)) {
            ticketToBuy++;
        }

        System.out.println(ticketToBuy);
    }
}
