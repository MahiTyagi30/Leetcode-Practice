class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();

        DSU dsu = new DSU(n);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s=accounts.get(i).get(j);
                if(!map.containsKey(s)){
                    map.put(s,i);
                }
                else{
                    dsu.union(i,map.get(s));
                }
            }
        }
        ArrayList<String>[] merge=new ArrayList[n];
        for(int i=0;i<n;i++){
            merge[i]=new ArrayList<>();
        }
        for(Map.Entry<String,Integer> it:map.entrySet()){
            String k=it.getKey();
            int node=dsu.find(it.getValue());
            merge[node].add(k);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merge[i].size()==0){
                continue;

            }
            Collections.sort(merge[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:merge[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}