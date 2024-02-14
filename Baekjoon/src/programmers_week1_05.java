import java.util.HashMap;
import java.util.Map;

public class programmers_week1_05 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++)
            map.put(players[i], i);

        for (String player : callings) {
            int rank = map.get(player);
            String behindPlayer = players[rank - 1];

            players[rank - 1] = player;
            players[rank] = behindPlayer;

            map.put(player, rank - 1);
            map.put(behindPlayer, rank);
        }
        return players;
    }
}
