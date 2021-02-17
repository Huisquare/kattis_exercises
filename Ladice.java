public class Ladice{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        String input = io.getLine();
        String[] inputArr = input.split(" ");
        Integer numItems = Integer.valueOf(inputArr[0]);
        Integer numDrawers = Integer.valueOf(inputArr[1]);
        UFDS set = new UFDS(numDrawers);
        for (int i = 0; i<numItems; i++){
            String choices = io.getLine();
            String[] choicesArr = choices.split(" ");
            int firstChoice = (int) Integer.valueOf(choicesArr[0]);
            int secChoice = (int) Integer.valueOf(choicesArr[1]);
            String result = set.union(firstChoice, secChoice);
            io.println(result);
        }
        io.close();
    }
}

class UFDS{
    public int[] parentArray;
    public int[] numEmptyDrawers;
    //constructor to construct numDrawers of nodes
    public UFDS(Integer numDrawers){
        numEmptyDrawers = new int[numDrawers+1];
        parentArray = new int[numDrawers+1];
        for (int i = 0; i < numDrawers +1; i++){
            parentArray[i] = i; //set parent to iteself first
            numEmptyDrawers[i] = 1; //each one itself is an empty drawer
        }
    }
    public int findParent(int drawer){
        if (drawer != parentArray[drawer]){
            // if the parent is not itself
            parentArray[drawer] = findParent(parentArray[drawer]);
            return parentArray[drawer];
        }
        else{
            //if the parent of drawer is itself
            return parentArray[drawer];
        }
    }
    public boolean haveSameParent(int drawerOne, int drawerTwo){
        return (findParent(drawerOne) == findParent(drawerTwo));
    }
    public String union(int drawerOne, int drawerTwo){
        if (haveSameParent(drawerOne, drawerTwo)){ //if both drawers belong to the same set
            //increase the item count in the set, by updating the item count of the gggfather
            int commonParent = parentArray[drawerOne];
            int availableDrawers = numEmptyDrawers[commonParent];
            if(availableDrawers != 0){
              //if there are available drawers
                numEmptyDrawers[commonParent] = numEmptyDrawers[commonParent]-1;
                return("LADICA");
            }
            else
                return("SMECE");
        }
        else{ //if the two int doesnt belong to the same parent/set
            int parentOne = findParent(drawerOne);
            int parentTwo = findParent(drawerTwo);
            parentArray[parentOne] = parentTwo; //set the parent of one to two
            numEmptyDrawers[parentTwo] = numEmptyDrawers[parentOne] + numEmptyDrawers[parentTwo];
            if(numEmptyDrawers[parentTwo] != 0){
                //occupy one space
                numEmptyDrawers[parentTwo] = numEmptyDrawers[parentTwo] -1;
                return("LADICA");
            }
            else
                return("SMECE");
        }
    }
}
