class Solution {
    public int minAddToMakeValid(String s) {
        char []arr = new char [s.length()];
        boolean []check = new boolean [s.length()];
        int count  = s.length();
        for(int i = 0; i < s.length(); i++)
            arr[i] = s.charAt(i);
        for(int i = 0; i < s.length() - 1; i++){
            for(int j = i + 1; j < s.length(); j++){
                if(!check[i] &&!check[j] && arr[i]== '(' && arr[j] == ')'){
                    check[i] = true;
                    check[j] = true;
                    count -= 2;
                }
            }
        }
        return count;
    }
}