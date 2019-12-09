package cpsc2150.sets;

import java.lang.reflect.Array;

/**
 * correspondences size = size and this = set
 * @invariants [set contains no duplicate values]
 */
public class ArraySet<T> extends SetAbs<T> implements ISet<T> {
    private T[] set;
    private int size = 0;


    ArraySet(){
        set = (T[]) new Object[ISet.MAX_SIZE];
    }
    public void add(T val){
        set[this.size] = val;
        size++;
    }

    public T remove(){

        T valRemoved = set[size - 1];
        set[size-1] = null;
        size--;
        return valRemoved;
    }

    public boolean contains(T val){
        //iterate through array, return true if finds val
        for(int i = 0; i < this.size; i++){
            if(set[i] == val){
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return this.size;
    }
}
