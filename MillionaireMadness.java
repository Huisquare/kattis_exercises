import java.util.PriorityQueue;

public class MillionaireMadness{
    //using prim's algo to find the minimax path
    public static int[] ver = {0, -1, 0, 1};
    public static int[] hor = {-1, 0, 1, 0};
    public static int[][] map;
    public static int[][] chosen; //1 if already in MST, 0 if not in MST
    public static PriorityQueue<Triple> pq;
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int numRows = io.getInt();
        int numCols = io.getInt();
        map = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                map[row][col] = io.getInt();
            }
        }
        chosen = new int[numRows][numCols];
        pq = new PriorityQueue<Triple>();
        int largestLadder = 0; //records largestLadder to bring
        //enqueue the first triple
        pq.add(new Triple(0, 0, 0)); //weight 0
        while(!pq.isEmpty()){
            Triple trip = pq.poll();
            //if the polled triple is already chosen
            if(chosen[trip.first][trip.sec] != 0) continue;
            if(trip.weight > largestLadder)
                largestLadder = trip.weight;
            if(trip.first == (numRows -1) && trip.sec == (numCols -1)) break;
            chosen[trip.first][trip.sec] = 1;
            for(int i = 0 ; i < 4; i ++){
                int newRow = trip.first + ver[i];
                int newCol = trip.sec + hor[i];
                if(newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols ) continue;
                int weight = map[newRow][newCol] - map[trip.first][trip.sec];
                if(chosen[newRow][newCol] == 0)
                    pq.add(new Triple(weight, newRow, newCol));
            }
        }
        io.println(largestLadder);
        io.close();
    }
}
class Triple implements Comparable<Triple>{
    public int weight;
    public int first;
    public int sec;
    public Triple(int w, int f, int s){
        weight = w;
        first = f;
        sec = s;
    }
    public int compareTo(Triple p){
        return (weight-p.weight); 
    }

}
