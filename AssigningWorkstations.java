import java.util.*;

public class AssigningWorkstations{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int numInputs = io.getInt();
        int maxWait = io.getInt();
        if(numInputs == 0) {io.println(0);}
        else{
            PriorityQueue<Tuple> inputPQ = new PriorityQueue<Tuple>(new sortByStart());
            for (int i = 0; i<numInputs; i++){
                int startTime = io.getInt();
                int usageTime = io.getInt();
                Tuple tup = new Tuple(startTime, usageTime);
                inputPQ.add(tup);
            }
            PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new sortByEndTime());
            pq.add(inputPQ.poll());
            int numSave = 0;
            while(!inputPQ.isEmpty()){
                Tuple currTup = inputPQ.poll();
                Tuple firstInQ = pq.peek();
                //io.println("first in pq is " + firstInQ.toString());
                int boundary = firstInQ.endTime() + maxWait;

                if(currTup.startTime >= firstInQ.endTime() && (currTup.startTime > boundary)){
                    boolean boundaryExceeded = true;
                    while(boundaryExceeded && !pq.isEmpty()){
                        firstInQ = pq.peek();
                        boundary = firstInQ.endTime() + maxWait;
                        if(currTup.startTime > boundary){
                            pq.poll();
                        }
                        else{
                            boundaryExceeded = false;
                        }
                    }
                }
                if((currTup.startTime >= firstInQ.endTime()) && (currTup.startTime <= boundary)){
                    pq.poll();
                    pq.add(currTup);
                    numSave++;
                }
                
                else{ //currTup startTime < firstInQ.endtime
                    pq.add(currTup);
                }
            }
            io.println(numSave);
        }
        io.close();
    }
}

class Tuple{
    int startTime;
    int duration;
    public Tuple(int start, int dur){
        startTime = start;
        duration = dur;
    }

    public int endTime(){
        int sum = startTime + duration;
        return sum;
    }
    // @Override
    // public String toString(){
    //     String prt = "(" + startTime + "," + duration + ")";
    //     return prt;
    // }
}
class sortByStart implements Comparator<Tuple>{
    public int compare(Tuple tuple1, Tuple tuple2){
        return (tuple1.startTime - tuple2.startTime);
    }
}

class sortByEndTime implements Comparator<Tuple>{
    public int compare(Tuple tup1, Tuple tup2){
        return (tup1.endTime() - tup2.endTime());
    }
}

