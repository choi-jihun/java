package Search;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Binary_Search {
	static int bin_Search(ArrayList<Integer> arrList, int target) {
		int start = 0;
		int end = arrList.size() - 1;
		while(start <= end) {
			int mid = (start+end) / 2;
			if(arrList.get(mid) == target)
				return mid;
			else if(arrList.get(end) > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrList =  new ArrayList<>();
		Random rnd = new Random();
		for(int i = 0; i < 8; i++)
			arrList.add(rnd.nextInt(50));
		Collections.sort(arrList);
		System.out.println("초기 배열 : " + arrList);
		System.out.println(bin_Search(arrList,6));
	}

}
