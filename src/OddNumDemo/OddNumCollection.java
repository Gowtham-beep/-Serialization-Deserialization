package OddNumDemo;

import java.util.Iterator;
import java.util.List;

public class OddNumCollection implements Iterable<Integer> {
    private List<Integer> numbers;

    OddNumCollection(List<Integer> numbers){
        this.numbers=numbers;
    }
    @Override
    public Iterator<Integer> iterator(){
        return new OddNumIterator(numbers);
    }

    private class OddNumIterator implements Iterator<Integer>{
        private List<Integer> nums;
        private int index =0;

        OddNumIterator(List<Integer> nums){
            this.nums=nums;
            moveNextOdd();
        }
        @Override 
        public boolean hasNext(){
            return  index<nums.size();
        }
        @Override 
        public Integer next(){
            Integer value = nums.get(index);
            index++;
            moveNextOdd();
            return value;
        }
        public void moveNextOdd(){
            while (index<nums.size() && (nums.get(index) % 2)==0){
                index++;
            }
        }
        
        
    }

}
