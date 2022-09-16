class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        boolean result = false;
        result = chk(s,t,i,j);
        return result;
    }
    public boolean chk(String s, String t, int i, int j){
        if(s.length() == 0)
            return true;
        if(t.length() == 0)
            return false;
        if(j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                if(i+1 == s.length())
                    return true;
                i++;
                j++;
                return chk(s,t,i,j);
            }
        else{
            j++;
            return chk(s,t,i,j);
        }
        }
        return false;
    }
}
