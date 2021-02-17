import java.util.*;

class LostMap{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int numLines = io.getInt();
        PriorityQueue<Triple> edgeList = new PriorityQueue<Triple>();
        getInputs(io, numLines, edgeList);
        UnionFind UFDS = new UnionFind(numLines + 1);

        while(UFDS.numDisjointSets() != 2){ //while the vertices are not connected
            Triple curr = edgeList.poll();
            if(!UFDS.isSameSet(curr.row, curr.col)){
                UFDS.unionSet(curr.row, curr.col);
                io.println(curr.row + " " + " " + curr.col);
            }
        }
        io.close();
    }
    private static void getInputs(Kattio io, int numLines, PriorityQueue<Triple> edgeList) {
        for(int row = 1 ; row < numLines +1 ; row ++){
            for(int col = 1; col < numLines +1 ; col ++){
                int weight = io.getInt();
                if(col < row){
                    continue;
                }
                else{
                    if(weight == 0){
                        continue;
                    }
                    else{
                        edgeList.add(new Triple(weight, row, col));
                    }
                }
            }
        }
    }

}

class Triple implements Comparable<Triple>{
    int weight, row, col;
    public Triple(int weight, int row, int col){
        this.weight = weight;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Triple trip){
        if(this.weight != trip.weight){
            return this.weight - trip.weight;
        }
        else if(this.row != trip.row){
            return this.row - trip.row;
        }
        else{
            return this.col - trip.col;
        }
    }
    @Override
    public String toString(){
        String s = "( " + weight + ", " + row + ", " + col + " )";
        return s;
    }

}
//from lecture notes
class UnionFind {                                              
    public int[] p;
    public int[] rank;
    public int numSets;
  
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      numSets = N;
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
      }
    }
  
    public int findSet(int i) { 
      if (p[i] == i) return i;
      else {
        p[i] = findSet(p[i]);
        return p[i]; 
      } 
    }
  
    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  
    public void unionSet(int i, int j) { 
      if (!isSameSet(i, j)) { 
        numSets--; 
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) 
            p[y] = x;
        else { 
            p[x] = y;
          if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
      } 
    }
  
    public int numDisjointSets() { return numSets; }
  }

