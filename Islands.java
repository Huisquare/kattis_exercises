import java.util.Queue;
import java.util.LinkedList;
class Islands{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        char[][] map;
        int[][] visited;
        int[] ver = {-1, 0, 1, 0};  //tgt its up, right, down, left (NESW)
        int[] hor = {0, 1, 0, -1};
        int r, c;

        //get the inputs
        r = io.getInt();
        c = io.getInt();
        map = new char[r][c];
        visited = new int[r][c];
        for (int i = 0; i < r; i++){
            String input = io.getLine();
            map[i] = input.toCharArray();
        }

        Queue<Tuple> Q = new LinkedList<>(); 

        int numIslands = 0;
        //to find out positions of cloud and islands
        for(int j = 0; j < r; j++){
            for (int k = 0; k < c; k++){
                if(map[j][k] == 'L' && visited[j][k] != 1){
                    numIslands ++;
                    Q.add(new Tuple(j, k));
                    visited[j][k] = 1;
                    while(!Q.isEmpty()){
                        Tuple currPos = Q.poll();
                        int currRow = currPos.row;
                        int currCol = currPos.col;
                        //set the map[row][col] to visited
                        visited[currRow][currCol] = 1;
                        
                        for (int i = 0; i < 4; i++){
                            int newRow = currRow + ver[i];
                            int newCol = currCol + hor[i];
                            
                            //io.println("the new row is " + newRow + " the new col is " + newCol);
                            if (newRow < 0 || newCol < 0 || newRow >= r|| newCol >=c){
                                continue;
                            }
                            if(visited[newRow][newCol] == 1){
                                continue;
                            }
                            if(map[newRow][newCol] == 'C' || map[newRow][newCol] == 'L'){
                                Q.add(new Tuple(newRow, newCol));
                                visited[newRow][newCol] = 1;
                            }
                        }
                    } 
                }
            }
        }


        
        
        //printing matrix
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        io.println(numIslands);


        io.close();
}
}

class Tuple{
    public int row, col;

    Tuple(int r, int c){
        row = r;
        col = c;
    }
}

