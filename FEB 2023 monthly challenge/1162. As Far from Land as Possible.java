// BFS
class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        for( int i = 0; i < n; i++){ // adding all land cells of grid
            for( int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                }
            }
        }

        int maxDist = 0;
        if(q.size() == 0 || q.size() == n*m) return -1;

        while(q.size() > 0){
            int size = q.size();
            while(size > 0){
                Pair info = q.remove();
                int cr = info.row;
                int cc = info.col;

                if(cr-1 >= 0 && grid[cr-1][cc] == 0){// checking above
                    grid[cr-1][cc] = 1;// if adjacent cell contain water i am changing status to land
                    q.add(new Pair(cr-1, cc));
                }

                if(cr+1 < n && grid[cr+1][cc] == 0){// checking below
                    grid[cr+1][cc] = 1;
                    q.add(new Pair(cr+1, cc));
                }

                if(cc-1 >= 0 && grid[cr][cc-1] == 0){// checking left
                    grid[cr][cc-1] = 1;
                    q.add(new Pair(cr, cc-1));
                }

                if(cc+1 < m && grid[cr][cc+1] == 0){// checking right
                    grid[cr][cc+1] = 1;
                    q.add(new Pair(cr,  cc+1));
                }
                size--;
            }
            maxDist++;
        }
        return maxDist - 1;
    }
}
