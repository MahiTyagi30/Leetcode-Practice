class Solution {
    class Pair{
        long first;
        long second;
        public Pair(long f,long s){
            this.first=f;
            this.second=s;
        }
    }
    class Tuple{
        long dist;
        long  node;
        public Tuple(long d,long n){
            this.dist=d;
            this.node=n;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int r[]:roads){
            int a=r[0];
            int b=r[1];
            int c=r[2];
            adj.get(a).add(new Pair(b,c));
            adj.get(b).add(new Pair(a,c));
        }
         long dist[]=new  long[n];
             long ways[]=new  long[n];
        for(int i=0;i<n;i++){
            dist[i]=Long.MAX_VALUE;;
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        long mod=(int)(1e9+7);
            PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->Long.compare(x.dist,y.dist));
            pq.add(new Tuple(0,0));
            while(!pq.isEmpty()){
                Tuple t=pq.peek();
                long d=t.dist;
                long nd=t.node;
                pq.remove();
                for(Pair it:adj.get((int)nd)){
                    long neigh=it.first;
                    long dst=it.second;
                    if(d+dst<dist[(int)neigh]){
                        dist[(int)neigh]=d+dst;
                        ways[(int)neigh]=(ways[(int)nd])%mod;
                        pq.add(new Tuple(d+dst,neigh));
                    }
                    else if(d+dst==dist[(int)neigh]){
                        ways[(int)neigh]=(ways[(int)neigh]+ways[(int)nd])%mod;
                    }
                }
            }
            return (int)(ways[n-1]%mod);

        }
        
    }
