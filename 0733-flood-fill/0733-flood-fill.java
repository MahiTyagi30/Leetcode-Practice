class Solution {
    public static void helper(int [][] image,boolean[][] vis,int i,int j,int color,int original){
         int n = image.length;
        int m = image[0].length;
        if(i<0||j<0||i>=n||j>=m||vis[i][j]==true||image[i][j]!=original){
            return;
        }
        vis[i][j]=true;
        image[i][j]=color;
         helper(image, vis, i + 1, j, color, original);
        helper(image, vis, i - 1, j, color, original);
        helper(image, vis, i, j + 1, color, original);
        helper(image, vis, i, j - 1, color, original);

    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n=image.length;
        int m=image[0].length;
        boolean vis[][]=new boolean[n][m];
        int org=image[sr][sc];
        if(org==color){
            return image;
        }
        helper(image,vis,sr,sc,color,org);
        return image;
    }
}