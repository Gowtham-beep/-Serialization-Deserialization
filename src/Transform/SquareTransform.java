package Transform;

import java.util.List;

public class SquareTransform {
    public static void main(String[] args){
        List<Integer> numbs = List.of(1,2,3,4,5,6,7,8,9,10);
        SquareIterable squares = new SquareIterable(numbs);

        for(long s:squares){
            System.out.println(s);
        }
    }
}
