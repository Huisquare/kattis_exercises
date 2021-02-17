import java.util.*;

public class WeakVertices{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        while(io.hasMoreTokens()){
            int numVertices = io.getInt();
            if(numVertices != -1){
                ArrayList<HashSet<Integer>> adjList = new ArrayList<HashSet<Integer>>();
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                for (int i = 0; i < numVertices; i++){
                    HashSet<Integer> set = new HashSet<Integer>();
                    for(int j = 0; j < numVertices; j++){
                        int input = io.getInt();
                        if(input == 1){
                            set.add(Integer.valueOf(j));
                        }
                    }
                    adjList.add(set);
                }
                HashSet<Integer> passedNumbers = new HashSet<Integer>();
                for (int k = 0; k<numVertices; k++){
                    if(!passedNumbers.contains(k)){
                        HashSet<Integer> currSet = adjList.get(k);
                        //for every entry in row k
                        outer: for (Integer neighbour: currSet){
                            for(Integer secNeighbour: currSet){
                                if (secNeighbour != neighbour){
                                    //check if the neighbour contain the secondary Neighbour too
                                    if(adjList.get(neighbour).contains(secNeighbour)){
                                        passedNumbers.add(k);
                                        passedNumbers.add(neighbour);
                                        passedNumbers.add(secNeighbour);
                                        break outer;
                                    }
                                }
                            }
                        }
                    }
                }

                for(int h = 0; h < numVertices; h++){
                    if(!passedNumbers.contains(h)){
                        io.print(h + " ");
                    }
                }
                io.println("");
            }
        }
        io.close();
    }
}
