import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        while(left<right){
            int sum = people[left] + people[right];
            if(sum > limit)
                right--;
            else{
                left++;
                right--;
            }
            count++;
        }
        if(left==right)
            count++;
        return count;
    }
}