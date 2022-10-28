import java.util.Arrays;

//a,b,c를 배열에 넣고 정렬하는게 전부인 문제였다...

class Solution {
    public int maximumScore(int a, int b, int c) {
        int []arr = {a,b,c};
        Arrays.sort(arr);
        int count = 0;
        while(arr[0]!=0 && arr[1] != 0 && arr[2] != 0){
            arr[1]--;
            arr[2]--;
            Arrays.sort(arr);
            count++;
        }
        while(arr[1]!=0&&arr[2]!=0){
            arr[1]--;
            arr[2]--;
            count++;
        }
        return count;
    }
}