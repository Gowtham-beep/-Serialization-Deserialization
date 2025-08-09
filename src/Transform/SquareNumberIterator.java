package Transform;

import java.util.Iterator;
import java.util.List;

public class SquareNumberIterator implements Iterator<Integer> {
    private List<Integer> numbs;
    private int index=0;

    public SquareNumberIterator(List<Integer> numbs){
        this.numbs=numbs;
    }
    @Override
    public boolean hasNext(){
        return index< numbs.size();
    }
    @Override
    public Integer next(){
        int value = numbs.get(index);
        index++;
        return value * value;
    }

}
