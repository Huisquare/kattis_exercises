import java.util.*;

public class Quest{
    public static void main(String[] args){
        TreeMap<Long, PriorityQueue<Long>> tree = new TreeMap<Long, PriorityQueue<Long>>();
        Kattio io = new Kattio(System.in, System.out);
        int numInputs = io.getInt();
        if(numInputs == 0){io.println("0");}
        for (int i = 0; i < numInputs; i++){
            String currCommand = io.getLine();
            String[] splitString = currCommand.split(" ");
            String command = splitString[0];
            if(command.equals("add")){
                Long energy = Long.valueOf(splitString[1]);
                Long reward = Long.valueOf(splitString[2]);
                if(tree.keySet().contains(energy)){
                    tree.get(energy).add(reward); //add reward to the pq in the energy node
                }
                else{
                    PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
                    tree.put(energy, pq);
                    pq.add(reward);
                }
            }
            else if(command.equals("query")){
                Long sumOfReward = 0L;
                Long toExtract = Long.valueOf(splitString[1]);
                if(!tree.isEmpty()){
                    while(toExtract.equals(tree.firstKey()) || (toExtract.compareTo(tree.firstKey()) > 0)){
                        Long greatestKey = tree.floorKey(toExtract);
                        if (greatestKey != null){
                            sumOfReward = Long.sum(sumOfReward, tree.get(greatestKey).poll());
                            if(tree.get(greatestKey).isEmpty()){tree.remove(greatestKey);} //if after polling, pq is empty 
                            toExtract -= greatestKey;
                        }
                        if(tree.isEmpty()){break;}
                    }
                }
                io.println(sumOfReward);
            }
        }
        io.close();
    }
}

