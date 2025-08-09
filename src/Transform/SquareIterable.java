package Transform;

import java.util.*;
public class SquareIterable implements Iterable<Integer>{
    private List<Integer> numbers;

    public SquareIterable(List<Integer> numbers){
        this.numbers=numbers;
    }

    @Override
    public Iterator<Integer>iterator(){
        return new SquareNumberIterator(numbers);
    }
}
