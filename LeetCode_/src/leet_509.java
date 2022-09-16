class Solution {
    int arr[] = new int[10000];
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n == 1)
            return n;
        if(n!=0)
            arr[n] = fib(n-1)+fib(n-2);
        return arr[n];
    }
}