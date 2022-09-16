package Sort;

class Merge_Sort {
	static void merge(int arr[], int start, int mid, int end) {
		int s = start;
		int m = mid + 1;
		int k = start;
		int[] temp = new int[end + 1];
		while(s <= mid && m <= end) {
			if(arr[s] <= arr[m])
				temp[k++] = arr[s++];
			else {
				temp[k++] = arr[m++];
			}
		}
		if(s > mid)
			while(m<=end)
				temp[k++] = arr[m++];
		else
			while(s<=mid)
				temp[k++] = arr[s++];
		for(int i = start;i<=end;i++)
			arr[i] = temp[i];
	}
	static void merge_sort(int arr[],int start, int end) {
		int mid = (start + end) / 2;
		if(start < end) {
			merge_sort(arr,start,mid);
			merge_sort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}

	static void printArr(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {3,15,21,7,9,13,20,16};
		merge_sort(arr,0,arr.length-1);
		printArr(arr);
	}

}
