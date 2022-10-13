class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        
        return DFS(numbers,target,0,0);
    }
    static int DFS(int []numbers, int target,int depth, int sum){
        if(depth == numbers.length){
            if(target == sum){
                answer++;
                return answer;
            }
                
        }
        else{
            DFS(numbers,target,depth+1,sum+(numbers[depth]));
            DFS(numbers,target,depth+1,sum-(numbers[depth]));
        }
        
        return answer;
    }
}