class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int start = 0;
        for(int i = 0; i < len - k; i++){
            int max = -1;
            for(int j = start; j < i + k + 1; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    start = j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}