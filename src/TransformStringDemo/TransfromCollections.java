package TransformStringDemo;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class TransfromCollections<T> implements Iterable<T> {
    private List<T> items;
    private Function<T,T> transformer;

    public TransfromCollections(List<T> items, Function<T,T> transformer){
        this.items=items;
        this.transformer=transformer;
    }
   @Override
   public Iterator<T> iterator(){
        return new TransformingIterator(items.iterator(),transformer);
   }

}
