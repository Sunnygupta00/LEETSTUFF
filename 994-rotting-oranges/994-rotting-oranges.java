// HERE BFS MAKES MORE SENSE
class Pair{
    int i;
    int j;
    Pair(int x, int y){
        i=x;
        j=y;
    }
}

class Solution {
    public int [][] dir = {{-1, 0},
                           {1, 0},
                           {0, -1},
                           {0, 1}
        
    };
    public int orangesRotting(int[][] grid) {
       if(grid.length == 0)return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int totalOranges = 0;;
    // TAKING ALL ROTTEN ORANGES  
        for(int i =0; i<n;i++){
            for(int j=0; j<m;j++){
                if(grid[i][j] == 2){ // IF ROTTEN
                   q.offer(new Pair(i,j));                    
                }else if(grid[i][j] == 1){
                    totalOranges++;
                }
            }
        }
        if(totalOranges == 0)return 0;
        // NOW WITH THE HELP OF ROTTEN ORANGES TRAVERSING IN ALL DIRECTIONS
        int time = 0;
        while(q.size()>0){
           int size = q.size();
            time++;
            for(int tt =0;tt<size;tt++){
                 Pair temp = q.poll(); 
            int i = temp.i;
            int j = temp.j;
           for(int []d : dir){
               int row = i+d[0];
               int col = j+d[1];
               if(isValid(grid, n, m, row, col)){
                   grid[row][col] = 2;
                   q.offer(new Pair(row, col));
                   totalOranges--;
               }
           }
            }
        }
      /*   for(int []row : grid){
            for(int col: row){
               System.out.print(col+" ");           // DEBUG
            }
             System.out.println();
        }
        */
 
        return totalOranges == 0 ? time-1 : -1;
    }
    public boolean isValid(int grid[][], int n, int m, int i, int j){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] !=1){
            return false;
        }
        return true;
    }
}