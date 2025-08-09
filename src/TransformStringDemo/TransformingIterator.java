package TransformStringDemo;

import java.util.Iterator;
import java.util.function.Function;

public class TransformingIterator<T> implements Iterator<T> {
    private Iterator<T> baseIterator;
    private Function<T,T> transformer;

    public TransformingIterator(Iterator<T> baseIterator,Function<T,T> transformer){
        this.baseIterator=baseIterator;
        this.transformer=transformer;
    }
    @Override
    public boolean hasNext(){
        return baseIterator.hasNext();
    }
    @Override
    public T next(){
        return transformer.apply(baseIterator.next());
    }
}
