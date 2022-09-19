package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {
	
	static void bucket_sort(double[] arr) {
		ArrayList<Double>[] bucket = new ArrayList[arr.length];
		for(int i = 0; i<arr.length; i++)
			bucket[i] = new ArrayList<Double>();
		for(int i = 0; i< arr.length; i++) {
			int idx = (int)arr[i]*arr.length;
			bucket[idx].add(arr[i]);
		}
		for(int i =0; i< arr.length; i++)
			Collections.sort(bucket[i]);
		
		int index = 0;
		for(int i=0; i<arr.length;i++)
			for(int j = 0, size = bucket[i].size(); j<size;j++)
				arr[index++] = bucket[i].get(j);
	}
	
	static void printArr(double arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] arr = {0.32,0.18,0.56,0.13,0.21,0.26,0.87,0.35};
		bucket_sort(arr);
		printArr(arr);
	}

}
