class Solution {
        class Pair{
        int distance;
        int node;
        public Pair(int d,int n){
            this.distance=d;
            this.node=n;
            
        }
    }
    public  int Count(int V, int[][] edges, int src,int th){
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int d=e[2];
            adj.get(u).add(new Pair(d,v));
            adj.get(v).add(new Pair(d,u));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
       int[] dist=new int[V];
               for(int i=0;i<V;i++){
                   dist[i]=(int)(1e9);
               }
               dist[src]=0;
               pq.add(new Pair(0,src));
               while(!pq.isEmpty()){
                   int d=pq.peek().distance;
                   int n=pq.peek().node;
                   pq.remove();
                   if (d > dist[n]) {
                                   continue;
                               }


                   for(int i=0;i<adj.get(n).size();i++){
                       int wt=adj.get(n).get(i).distance;
                       int node=adj.get(n).get(i).node;
                       if(wt+d<dist[node]){
                           dist[node]=wt+d;
                           pq.add(new Pair(dist[node],node));
                       }
                   }
               }
                int c=0;
                   for(int i=0;i<V;i++){
                    if(dist[i]<=th){
                        c++;
                    }
                   }
                   return c;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int a=Count(n,edges,i,distanceThreshold);
            res[i]=a;


        }
        int fres=-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(res[i]<=ans){
              fres=i;
              ans=res[i];
            }
        }
        return fres;
    }
}