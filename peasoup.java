import java.util.*;
public class peasoupAndPancakes{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numOfRes = sc.nextInt();
        int numOfMenuItems;
        String resName;
        String menuItem;
        Boolean peasoup = false;
        Boolean pancake = false;
        String dis = "Anywhere is fine I guess";

    for (int i = 1; i < numOfRes+1; i++){ //iterate through the number of restaurants
        int restNum = i;
        numOfMenuItems = sc.nextInt();
        sc.nextLine();
        resName = sc.nextLine();
        for (int j = 1; j < numOfMenuItems + 1; j++){ //iterate through the number of menu items in the current restaurant
            menuItem = sc.nextLine();
            if (menuItem.equals("pea soup")){
                peasoup = true;
            }
            if (menuItem.equals("pancakes")){
                pancake = true;
            }
        }
        if (peasoup & pancake){
            System.out.println(resName);
            return;
        }else{
            peasoup = false;
            pancake = false;
        }       
    }
System.out.println(dis);
    }
}