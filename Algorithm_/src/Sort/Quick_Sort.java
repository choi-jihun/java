package Sort;

public class Quick_Sort {
	static void swap(int arr[],int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void quick_sort(int arr[], int start, int end) {
		if(start>=end)
			return;
		int pivot = partition(arr,start,end);
		quick_sort(arr,start,pivot-1);
		quick_sort(arr,pivot+1,end);
	}
	
	static int partition(int arr[],int start, int end) {
		int s = start;
		int e = end;
		int pivot = arr[start];
		while(s < e) {
			while(arr[e] > pivot && s < e)
				e--;
			while(arr[s] <= pivot && s < e)
				s++;
			swap(arr,s,e);
		}
		swap(arr,start,s);
		return s;
	}
	
	
	static void printArr(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {3,15,21,7,9,13,20,16};
		quick_sort(arr,0,arr.length-1);
		printArr(arr);
	}

}
