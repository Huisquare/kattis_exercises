import java.util.*;

public class JoinStrings{

  public static void main(String[] args){
    Kattio io = new Kattio(System.in, System.out);
    int numberOfStrings = io.getInt();
    if (numberOfStrings == 1){
      String word = io.getWord();
      io.println(word);
    }
    else{
      Map<Integer, Node> mapOfNodes = new HashMap<Integer, Node>(numberOfStrings);
      for (int i = 0; i < numberOfStrings; i++){
        String word = io.getWord();
        Node newNode = new Node(i+1, word);
        mapOfNodes.put(Integer.valueOf(i+1), newNode);
      }
      Node currFirstNode = null;
      for (int j = 0; j < numberOfStrings-1; j++){
        int head = io.getInt();
        int tail = io.getInt();
        Node nowNode = mapOfNodes.get(Integer.valueOf(head));
        currFirstNode = nowNode;
        Node nextNode = mapOfNodes.get(Integer.valueOf(tail));
        Node realNowNode = mapOfNodes.get(nowNode.getLastIndex());
        realNowNode.setNext(nextNode);
        nowNode.setLastIndex(nextNode.getLastIndex());
      }

      for (int k = 0; k < numberOfStrings; k++){
        io.print(currFirstNode);
        currFirstNode = currFirstNode.getNext();
      }
    }
    io.close();
  }
}

class Node{
  Integer index;
  String ownString;
  Node next = null;
  Integer lastIndex = null;

  Node(Integer index, String ownString){
    this.index = index;
    this.ownString = ownString;
    this.lastIndex = index;
  }

  public void setNext(Node next){
    this.next = next;
  }
  public Node getNext(){
    return this.next;
  }
  public void setLastIndex(Integer lastIndex){
    this.lastIndex = lastIndex;
  }
  public Integer getLastIndex(){
    return this.lastIndex;
  }
  @Override
  public String toString(){
    String x = ownString;
    return x;
  }
}

