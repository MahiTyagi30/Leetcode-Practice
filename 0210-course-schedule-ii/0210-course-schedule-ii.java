class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
       List<List<Integer>> list=new ArrayList<>();
       for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

       for(int i=0;i<prerequisites.length;i++){
        int u=prerequisites[i][1];
        int v=prerequisites[i][0];
        list.get(u).add(v);
       }
       int[] indegree=new int[numCourses];
       for(int i=0;i<numCourses;i++){

        for(int j=0;j<list.get(i).size();j++){
            int node=list.get(i).get(j);
            indegree[node]++;
        }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            q.add(i);
        }
       }
       int[] top=new int[numCourses];
       int i=0;
       while(!q.isEmpty()){
        int node=q.peek();
        q.remove();
        top[i++]=node;
        for(int it:list.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.add(it);
            }
        }


       }
       if(i != numCourses){
    return new int[0];
}
       return top;
    }
}