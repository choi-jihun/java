class Solution {
    static int[] visited;
    static int[] check;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses+1];
        check = new int[numCourses+1];
        int[][] arr = new int[numCourses+1][numCourses+1];
        for(int i=0;i<prerequisites.length;i++){
               arr[prerequisites[i][0]][prerequisites[i][1]]=1;
        }
        for(int i=0;i<numCourses+1;i++){
     
            if(check[i] != 1 &&has_cycle(i,arr, numCourses+1)){
                return false;
            }
        }
        return true;
    }

    public boolean has_cycle(int n, int arr[][], int len) {
      int i;
      int cycle = 0;
        
      if (visited[n] == 0) {
            if(check[n]==1)
                return false;
         visited[n] = 1;
            check[n] = 1;
         for (i = 0; i < len; i++)
            if (arr[n][i] == 1)
               if (has_cycle(i,arr,len))
                  return true;
         visited[n] = 0;
           
         return false;
      } else
         return true;
   }


}