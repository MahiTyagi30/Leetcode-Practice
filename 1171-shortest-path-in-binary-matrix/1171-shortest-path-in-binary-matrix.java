class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Check if the start or end is blocked
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        // Create a copy of the grid
        int[][] gridCopy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, gridCopy[i], 0, grid[i].length);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        gridCopy[0][0] = 1; // Mark the starting point

        // Define the 8 possible directions
        int[] rowadd = {0, 1, 1, -1, -1, 1, 0, -1};
        int[] coladd = {1, 1, 0, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for (int i = 0; i < 8; i++) {
                int curr_row = rowadd[i] + r;
                int curr_col = coladd[i] + c;

                // Check boundaries and if the cell is walkable
                if (curr_row >= 0 && curr_row < gridCopy.length &&
                    curr_col >= 0 && curr_col < gridCopy[0].length &&
                    gridCopy[curr_row][curr_col] == 0) {
                    
                    q.add(new Pair(curr_row, curr_col));
                    gridCopy[curr_row][curr_col] = gridCopy[r][c] + 1; // Mark the path length
                }
            }
        }

        // Check the value at the destination cell
        return gridCopy[gridCopy.length - 1][gridCopy[0].length - 1] == 0
               ? -1
               : gridCopy[gridCopy.length - 1][gridCopy[0].length - 1];
    }
}
