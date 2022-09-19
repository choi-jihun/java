package Sort;

import java.util.ArrayList;
import java.util.Collections;

//버킷정렬 무슨 소린지 이해가 안되서 참조
//https://fixsy.org/ko/%EB%B2%84%ED%82%B7-%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#Python_Java_%EB%B0%8F_CC%EC%9D%98_%EB%B2%84%ED%82%B7_%EC%A0%95%EB%A0%AC_%EC%BD%94%EB%93%9C


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
