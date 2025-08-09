package OddNumDemo;

import java.util.*;

public class OddIterableDemo {
    public static void main(String[] args){
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
        OddNumCollection odds = new OddNumCollection(nums);

        for(int o:odds){
            System.out.println(o);
        }
    }
}