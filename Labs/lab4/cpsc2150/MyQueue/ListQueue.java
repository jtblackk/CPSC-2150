package cpsc2150.MyQueue;
import java.util.*;

/**
 * @inv 0 <= myQ.size() <= MAX_DEPTH
 * Correspondence: queue_size = myQ.size()
 * Correspondence: MAX_DEPTH = MAX_DEPTH
 */
public class ListQueue implements IQueue {
    //this time store the queue in a list
    //myQ.get(0) is the front of the queue
    private List<Integer> myQ;

    /**
     * @post myQ.size() == 0
     * @post myQ == empty queue
     */
    ListQueue(){
        myQ = new ArrayList<Integer>();
    }

    /**
     * {see IQueue.add()}
     */
    public void add(Integer X){
        myQ.add(X);
    }

    /**
     * {see IQueue.pop()}
     */
    public Integer pop(){
        int front = myQ.get(0);
        myQ.remove(0);
        return front;
    }

    /**
     * {see IQueue.size()}
     */
    public int size(){
        return myQ.size();
    }
}
