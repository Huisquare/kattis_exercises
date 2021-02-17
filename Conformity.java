import java.util.*;

public class Conformity{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int numOfInputs = io.getInt();
        Map<String, Integer> map = new HashMap<String, Integer>(numOfInputs);
        int[] Arr = new int[5];
        int maxCount = 0;
        int numOfCombi = 0;
        for(int j = 0; j< numOfInputs; j++){
            for (int i = 0; i <5; i++){
                Arr[i] = io.getInt();
            }
            Arrays.sort(Arr);
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 5; k++){
                String str = Integer.toString(Arr[k]);
                sb.append(str);
            }
            String strForm = sb.toString();
            if (map.containsKey(strForm)){
                Integer count = map.get(strForm);
                count++;
                map.replace(strForm, count);
                if (count > maxCount)
                    maxCount = count;
            }
            else{
                map.put(strForm, 1);
                if (maxCount < 1)
                    maxCount = 1;
            }
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            String key = pair.getKey();
            Integer freq = pair.getValue();
            if(freq == maxCount)
                numOfCombi += freq;
        }
        io.println(numOfCombi);
        io.close();
    }
}
