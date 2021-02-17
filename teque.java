import java.util.*;

public class teque{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int numOfStr = io.getInt();
        Map<Integer, Integer> frontQueue = new HashMap<Integer, Integer>();
        Map<Integer, Integer> backQueue = new HashMap<Integer, Integer>();
        Integer frontQFrontIdx = null;
        Integer frontQBackIdx = null;
        Integer backQFrontIdx = null;
        Integer backQBackIdx = null;
        for (int i = 0; i < numOfStr; i++){
            String currString = io.getLine();
            String[] splitString = currString.split(" ");
            String function = splitString[0];
            Integer value = Integer.valueOf(splitString[1]);
            if(function.equals("push_back")){
                if(backQueue.isEmpty() & frontQueue.isEmpty()){ //if this is the first entry
                    frontQueue.put(0, value); //put the value into the frontQ
                    frontQBackIdx = 0;
                    frontQFrontIdx = 0; 
                    //io.println("push_back: first entry front q " + frontQueue);
                    //io.println("push_back: first entry back q " + backQueue);
                }
                else if(backQueue.isEmpty()){
                    backQueue.put(0, value);
                    backQBackIdx = 0;
                    backQFrontIdx = 0;
                    //io.println("push_back empty then backQ " + backQueue);
                }
                else{
                    backQBackIdx ++;
                    backQueue.put(backQBackIdx, value);
                    //io.println("push_back nonempty backQ" + backQueue);
                }
                //balanceQueues(frontQueue, backQueue, frontQFrontIdx, frontQBackIdx, backQFrontIdx, backQBackIdx);
                int frontQueueSize = frontQueue.size();
                int backQueueSize = backQueue.size();
                if (frontQueueSize > (backQueueSize +1)){ // if top Queue size is 2 units bigger than bottom queue size
                    if(backQueue.isEmpty()){
                        Integer transfer = frontQueue.get(frontQBackIdx); //get the num to be transferred to front of backQ
                        frontQueue.remove(frontQBackIdx);
                        frontQBackIdx --;
                        backQueue.put(0, transfer);
                        backQFrontIdx = 0;
                        backQBackIdx = 0;
                    }
                    else{
                        Integer transfer = frontQueue.get(frontQBackIdx); //get the num to be transferred to front of backQ
                        frontQueue.remove(frontQBackIdx);
                        frontQBackIdx --;
                        backQFrontIdx --;
                        //System.out.println("im updated backQfrontIdx to " + backQFrontIdx);
                        backQueue.put(backQFrontIdx, transfer);
                    }  
                }
                else if(backQueueSize > frontQueueSize){
                    //shift the front of the back queue to the back of the front queue
                    Integer transfer = backQueue.get(backQFrontIdx);
                    //System.out.println("i got the backQfrontidx of " + backQFrontIdx);
                    backQueue.remove(backQFrontIdx);
                    backQFrontIdx ++;
                    frontQBackIdx++;
                    frontQueue.put(frontQBackIdx, transfer);
                }
                //io.println("after balancing queue after push_back: front q " + frontQueue);
                //io.println("after balancing queue after push_back: back q " + backQueue);

            }
            else if(function.equals("push_front")){
                if(frontQueue.isEmpty()){ //if this is the first entry
                    frontQueue.put(0, value); //put the value into the backQ
                    frontQBackIdx = 0;
                    frontQFrontIdx = 0;
                    //io.println("push_front: first entry in front q: " + frontQueue);
                    //io.println("push_front: first entry in back q: " + backQueue);
                }
                else{
                    frontQFrontIdx --;
                    frontQueue.put(frontQFrontIdx, value);
                    //io.println("push_front : nonempty front q: " + frontQueue);
                    //io.println("push_front : nonempty back q: " + backQueue);
                }
                //balanceQueues(frontQueue, backQueue, frontQFrontIdx, frontQBackIdx, backQFrontIdx, backQBackIdx);
                int frontQueueSize = frontQueue.size();
                int backQueueSize = backQueue.size();
                if (frontQueueSize > (backQueueSize +1)){ // if top Queue size is 2 units bigger than bottom queue size
                    if(backQueue.isEmpty()){
                        Integer transfer = frontQueue.get(frontQBackIdx); //get the num to be transferred to front of backQ
                        frontQueue.remove(frontQBackIdx);
                        frontQBackIdx --;
                        backQueue.put(0, transfer);
                        backQFrontIdx = 0;
                        backQBackIdx = 0;
                    }
                    else{
                        Integer transfer = frontQueue.get(frontQBackIdx); //get the num to be transferred to front of backQ
                        frontQueue.remove(frontQBackIdx);
                        frontQBackIdx --;
                        backQFrontIdx --;
                        //System.out.println("im updated backQfrontIdx to " + backQFrontIdx);
                        backQueue.put(backQFrontIdx, transfer);
                    }  
                }
                else if(backQueueSize > frontQueueSize){
                    //shift the front of the back queue to the back of the front queue
                    Integer transfer = backQueue.get(backQFrontIdx);
                    //System.out.println("i got the backQfrontidx of " + backQFrontIdx);
                    backQueue.remove(backQFrontIdx);
                    backQFrontIdx ++;
                    frontQBackIdx++;
                    frontQueue.put(frontQBackIdx, transfer);
                }
                //io.println("after balancing queue after push_front: front q " + frontQueue);
                //io.println("after balancing queue after push_front: back q " + backQueue);
            }
            else if(function.equals("push_middle")){
                if(frontQueue.isEmpty()){
                    frontQueue.put(0, value);
                    frontQBackIdx = 0;
                    frontQFrontIdx = 0;
                    //io.println("push_middle : empty front queue " + frontQueue);
                    //io.println("push_middle : empty front Queue: back Queue " + backQueue);
                }
                else{
                    frontQBackIdx ++;
                    frontQueue.put(frontQBackIdx, value);
                    //io.println("push_middle : non empty front q " + frontQueue);
                    //io.println("push_middle : non empty back q " + backQueue);
                }
                //balanceQueues(frontQueue, backQueue, frontQFrontIdx, frontQBackIdx, backQFrontIdx, backQBackIdx);
                int frontQueueSize = frontQueue.size();
                int backQueueSize = backQueue.size();
                if (frontQueueSize > (backQueueSize +1)){ // if top Queue size is 2 units bigger than bottom queue size
                    if(backQueue.isEmpty()){
                        Integer transfer = frontQueue.get(frontQBackIdx); //get the num to be transferred to front of backQ
                        frontQueue.remove(frontQBackIdx);
                        frontQBackIdx --;
                        backQueue.put(0, transfer);
                        backQFrontIdx = 0;
                        backQBackIdx = 0;
                    }
                    else{
                        Integer transfer = frontQueue.get(frontQBackIdx); //get the num to be transferred to front of backQ
                        frontQueue.remove(frontQBackIdx);
                        frontQBackIdx --;
                        backQFrontIdx --;
                        //System.out.println("im updated backQfrontIdx to " + backQFrontIdx);
                        backQueue.put(backQFrontIdx, transfer);
                    }  
                }
                else if(backQueueSize > frontQueueSize){
                    //shift the front of the back queue to the back of the front queue
                    Integer transfer = backQueue.get(backQFrontIdx);
                    //System.out.println("i got the backQfrontidx of " + backQFrontIdx);
                    backQueue.remove(backQFrontIdx);
                    backQFrontIdx ++;
                    frontQBackIdx++;
                    frontQueue.put(frontQBackIdx, transfer);
                }
                //io.println("after balancing queue after push_middle: front q " + frontQueue);
                //io.println("after balancing queue after push_middle: back q " + backQueue);
            }
            else if(function.equals("get")){
                if(value > frontQueue.size()-1){
                    Integer index = value - frontQueue.size();
                    Integer finalIndex = index + backQFrontIdx;
                    io.println(backQueue.get(finalIndex));
                }
                else{
                    Integer finalIndex = value + frontQFrontIdx;
                    io.println(frontQueue.get(finalIndex));
                }
            }
        }
        //io.println(frontQueue.toString());
        //io.println(backQueue.toString());
        io.close();
    }
