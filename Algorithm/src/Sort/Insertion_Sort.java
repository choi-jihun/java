package Sort;

class Insertion_Sort {
	 void insertion_sort(int arr[]) {
		for(int i = 1; i < arr.length; i++)
		{
			int target = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > target) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = target;
		}
	}
	
	static void printArr(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,9,23,15,25};
		Insertion_Sort obj = new Insertion_Sort();
		obj.insertion_sort(arr);
		printArr(arr);
	}

}