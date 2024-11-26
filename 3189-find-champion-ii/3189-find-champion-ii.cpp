class Solution {
public:
    int findChampion(int n, vector<vector<int>>& edges) {
        vector<int> vis(n, 0);
        for(int i = 0; i < edges.size(); i++){
            int u = edges[i][0];
            int v = edges[i][1];
            vis[v]++;
        }
        int res = -1, cnt = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                if(cnt > 0){
                    return -1;
                }
                else{
                    cnt++;
                    res = i;
                }
            }
        }
        return res;
    }
};