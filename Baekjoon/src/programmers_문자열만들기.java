public class programmers_문자열만들기 {

    class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();
            String[] arr = s.split(" ", -1);

            for (String now : arr) {
                if (now.length() == 0) {
                    answer.append(" ");
                } else {
                    answer.append(now.substring(0, 1).toUpperCase());
                    answer.append(now.substring(1).toLowerCase());
                    answer.append(" ");
                }
            }

            return answer.substring(0, answer.length() - 1);
        }
    }
}