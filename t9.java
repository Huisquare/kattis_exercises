import java.util.*;

public class t9{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numOfInputs = sc.nextInt();
        sc.nextLine(); //to prevent glitch
        String output = ""; //the final output of the string
        for (int i = 0; i < numOfInputs; i++){ //looping through every input
            String input = sc.nextLine(); //save the input in a string
            for (int j = 0; j < input.length(); j++){ //looping through every char in the string 
                char character = input.charAt(j); //saving the current char as character
                int acVal = (int) character; //saving the ASCII value of character into acVal
                String idOfChar = getCode(acVal); //get the code in String form to be concatenated
                if (output.isEmpty() == false){ //if the output is not empty
                    if(idOfChar.charAt(0) == output.charAt(output.length()-1)){ //compare the first letter of code with last letter in half done output
                        output = output.concat(" "); // if the letters are the same, then add a space
                    }
                }

                output = output.concat(idOfChar);//add the substrings to the string
            }
            System.out.println("Case #" + (i+1) + ": " + output);
            output = "";
        }
    }
    public static String getCode(int asc){
        String[] ascArr = new String[26];
        ascArr[0] = "2";
        ascArr[1] = "22";
        ascArr[2] = "222";
        ascArr[3] = "3";
        ascArr[4] = "33";
        ascArr[5] = "333"; //f
        ascArr[6] = "4";
        ascArr[7] = "44";
        ascArr[8] = "444"; //i
        ascArr[9] = "5";
        ascArr[10] = "55";
        ascArr[11] = "555"; //l
        ascArr[12] = "6"; //m
        ascArr[13] = "66"; //n
        ascArr[14] = "666"; //o
        ascArr[15] = "7"; //p
        ascArr[16] = "77"; //q
        ascArr[17] = "777"; //r
        ascArr[18] = "7777"; //s
        ascArr[19] = "8";
        ascArr[20] = "88";
        ascArr[21] = "888";
        ascArr[22] = "9";
        ascArr[23] = "99";
        ascArr[24] = "999";
        ascArr[25] = "9999";


        if (asc == 32){ //if char is a spacing between words
            return "0";
        }else{
            return ascArr[asc-97];
        }
    }
}
