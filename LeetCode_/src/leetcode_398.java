import java.util.Random;

class Solution {
    int []nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random rand = new Random();
        while(true){
            int i = rand.nextInt(nums.length);
            if(target == nums[i])
                return i;
        }
    }
}