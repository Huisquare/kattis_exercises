import java.util.*;

public class sortOfSorting{
    public static void main(String args[]){
        int numOfInputs;
        SSComparator ssCompare = new SSComparator();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            numOfInputs = sc.nextInt();
            sc.nextLine();
            ArrayList<String> myList = new ArrayList<String>();
            if(numOfInputs != 0){
                for(int i = 0; i < numOfInputs; i++){
                    myList.add(sc.nextLine());
                }
                Collections.sort(myList, ssCompare);
                for(String s: myList){
                    System.out.println(s);
                }
                System.out.println("");
            }
        }
    }
}

class SSComparator implements Comparator<String>{
    public int compare(String a, String b){
        return a.substring(0,2).compareTo(b.substring(0,2));
    }
    public boolean equals(Object obj){
        return this == obj;
    }
}