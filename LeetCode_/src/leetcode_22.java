import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/solutions/10136/easy-java-solution/?languageTags=java
//위 주소에서 참고
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==0)
            return res;
        add(res,"",n,n);
        return res;
    }
    void add(List<String> res, String ans, int left, int right){
        if(right == 0)
            res.add(ans);
        if(left>0)
            add(res,ans + "(",left-1,right);
        if(right>left)
            add(res,ans+")",left,right-1);
    }
}