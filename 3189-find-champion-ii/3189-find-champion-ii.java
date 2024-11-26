class Solution {
    public int findChampion(int n, int[][] edges) {
        int indeg[]=new int[n];
        for(int i=0;i<edges.length;i++){
            int a=edges[i][1];
            indeg[a]++;
        }

        int res=-1;
        int c=0;
        for(int i=0;i<n;i++)
              {
                if(indeg[i]==0){
                  if(c>0){
                    res=-1;
                     break;

                 }
        else{
            res=i;
            c++;
        }
    }

}   
return res;
 }
}