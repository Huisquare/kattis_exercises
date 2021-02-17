import java.math.*;
import java.util.*;

public class ADifferentProblem {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        //Scanner sc = new Scanner(System.in);
        while (io.hasMoreTokens()){
            Long input1 = io.getLong();
            Long input2 = io.getLong();
            Long result = input1 - input2;
            io.println(Math.abs(result));
        }
        io.close();
    }
}

