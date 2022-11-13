import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/solutions/2458562/simple-recursion-original-solution-java-explained-each-step/?q=explain&orderBy=most_relevant&languageTags=java
// https://leetcode.com/problems/subsets/solutions/694371/java-well-explained-with-jpg/?q=explain&orderBy=most_relevant
//코드 참조랑 설명도 잘 되있다...

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        if(nums.length == 0)
            return answer;
        dfs(answer,number,0,nums);
        return answer;
    }
    public void dfs(List<List<Integer>> answer, List<Integer> number, int start, int[] nums){
        if(start == nums.length){
            answer.add(new ArrayList<>(number));
            return;
        }
        dfs(answer,number,start+1,nums);
        number.add(nums[start]);
        dfs(answer,number,start+1,nums);
        number.remove(number.size()-1);
    }
}
