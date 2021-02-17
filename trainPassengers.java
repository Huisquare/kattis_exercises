public class trainPassengers{
    public static void main(String[] args){
      Kattio io = new Kattio(System.in, System.out);
      int numOfStations;
      int capacity;
      int num_left;
      int num_entered;
      int num_stayed_behind;
      int current_num_ppl = 0;
      Boolean impossible = false;
      capacity = io.getInt();
      numOfStations = io.getInt();
      for(int i = 0; i < numOfStations; i++){
        num_left = io.getInt();
        num_entered = io.getInt();
        num_stayed_behind = io.getInt();
        current_num_ppl = current_num_ppl + num_entered - num_left;
        if(i == 0){
          if(num_left != 0){
            //checking if people left the train at 1st station
            impossible = true;
            continue;
          }
        }
        if(i == (numOfStations-1)){
          if((num_stayed_behind != 0) || current_num_ppl != 0){
            //checking if people waited at last station
            //or the train is not empty at last station
            impossible = true;
            continue;
          }
        }
        if ((current_num_ppl < 0) || (current_num_ppl > capacity)){
          //checking if num of people on train is negative or exceeds capacity
          impossible = true;
          continue;
        }
        if ((current_num_ppl < capacity) && (num_stayed_behind != 0)){
          //checking if people were left behind when there was still space
          //on the train
          impossible = true;
          continue;
          }
        }
        if (impossible){
          io.println("impossible");
        }
        else{
          io.println("possible");
        }
      io.close();
      }
    }
  
