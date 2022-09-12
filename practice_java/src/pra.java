import java.util.Arrays;

public class pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		System.out.println(obj.findTheDifference("abcd", "abcde"));
	}

}

class Solution {
    public char findTheDifference(String s, String t) {
        char ch =' ';
        char arr1[] = s.toCharArray();
        Arrays.sort(arr1);
        char arr2[] = t.toCharArray();
        Arrays.sort(arr2);
        
        for(int i = 0; i < arr1.length; i++)
            if(arr1[i]!=arr2[i])
            {
                ch = arr2[i+1];
                System.out.println(ch + "반복문 안쪽");
                return ch;
            }
        System.out.println(ch + "반복문 바깥");
        return ch;
    }

}