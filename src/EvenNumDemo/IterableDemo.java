package EvenNumDemo;

import java.util.*;
class EvenNumCollection implements Iterable<Integer> {
    private List<Integer> numbers;
    
    public EvenNumCollection(List<Integer> numbers){
        this.numbers=numbers;
    }
    
    @Override
    public Iterator<Integer> iterator(){
        return new EvenNumberIterator(numbers);
    }
    
    private class EvenNumberIterator implements Iterator<Integer>{
        private List<Integer> nums;
        private int index =0;
        
        EvenNumberIterator(List<Integer> nums){
            this.nums=nums;
            moveToNextEven();
        }
        @Override
        public boolean hasNext(){
            return index < nums.size();
        }
        @Override
        public Integer next(){
           Integer value = nums.get(index);
           index++;
            moveToNextEven();
            return value;
        }
        private void moveToNextEven(){
            while (index<nums.size() && nums.get(index)%2!=0){
                index++;
            }
        }
        
    }
}
public class IterableDemo{
    public static void main(String[] args){
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8);
        
        EvenNumCollection evens = new EvenNumCollection(nums);
        
        for(int n : evens){
            System.out.println(n);
        }
    }
}
