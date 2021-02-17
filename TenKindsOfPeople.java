import java.util.*;
public class TenKindsOfPeople {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int numRows = io.getInt();
        int numCols = io.getInt();
        char[][] map = new char[numRows][numCols];
        int[][] visited = new int[numRows][numCols];
        for(int i = 0; i < numRows; i++){
            String input = io.getLine();
            map[i] = input.toCharArray();
        }
        int numQueries = io.getInt();
        int groupNumber = 1;
        int [] ver = {-1, 0, 1, 0};
        int [] hor = {0, 1, 0, -1};
        Queue<Pair> Q = new LinkedList<>();
        for(int j = 0; j < numQueries; j++){
            int c1First = io.getInt() -1;
            int c1Sec = io.getInt() -1;
            int c2First = io.getInt() -1;
            int c2Sec = io.getInt() -1;
            
            if(visited[c1First][c1Sec] != visited[c2First][c2Sec]){
                //if coordinates belong to diff group
                io.println("neither");
                continue;
            }
            else if (map[c1First][c1Sec] != map[c2First][c2Sec]){
                io.println("neither");
                continue;
            }
            else if(visited[c1First][c1Sec] == visited[c2First][c2Sec]){
                if(visited[c1First][c1Sec] != 0 && visited[c2First][c2Sec] != 0){
                    if(map[c1First][c1Sec] == '0'){
                        io.println("binary");
                        continue;
                    }
                    else{
                        io.println("decimal");
                        continue;
                    }
                }
                else{ //both coord dont belong to any groups yet
                    //do a breadth first search from source to destination
                    //along the way, set all the entries to same group
                    Pair startVertex = new Pair(c1First, c1Sec);
                    //set this vertex to visited
                    visited[c1First][c1Sec] = groupNumber;
                    //enqueue this startvertex into the queue
                    Q.add(startVertex);
                    
                    while(!Q.isEmpty()){
                        Pair currVertex = Q.poll();
                        visited[currVertex.first][currVertex.sec] = groupNumber;
                        for(int k = 0; k < 4; k ++){
                            int newRow = currVertex.first + ver[k];
                            int newCol = currVertex.sec + hor[k];
                            if(newRow >= numRows || newRow < 0 || newCol >= numCols || newCol < 0) continue;
                            if(map[newRow][newCol] == map[c1First][c1Sec] && visited[newRow][newCol] == 0){
                                Q.add(new Pair(newRow, newCol));
                                visited[newRow][newCol] = groupNumber;
                            }
                        } 
                    }
                    groupNumber++;
                    if(visited[c1First][c1Sec] == visited[c2First][c2Sec]){
                        if(map[c1First][c1Sec] == '0'){
                            io.println("binary");
                            continue;
                        }
                        else{
                            io.println("decimal");
                            continue;
                        }
                    }
                    else{
                        io.println("neither");
                    }
                }

            }
            Q.clear();
        }
        io.close();
    }
}

class Pair{
    public int first;
    public int sec;
    public Pair(int x, int y){
        first = x;
        sec = y;
    }
}

