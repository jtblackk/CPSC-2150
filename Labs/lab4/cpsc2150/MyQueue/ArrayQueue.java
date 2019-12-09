package cpsc2150.MyQueue;

/**
 * @inv 0 <= depth <= MAX_DEPTH
 * Correspondence: queue_size = depth
 * Correspondence: MAX_DEPTH = MAX_DEPTH
 */
public class ArrayQueue implements IQueue {
    // where the data is stored. myQ[0] is the front of the queue
    private Integer[] myQ;

    //tracks how many items in the queue
    // also used to find the end of the queue
    private int depth;

    /**
     * @post depth == 0
     * @post myQ == empty queue of size MAX_DEPTH
     */
    ArrayQueue(){
        this.depth = 0;
        this.myQ = new Integer[this.MAX_DEPTH];
    }

    /**
     * {see IQueue.add()}
     */
    public void add(Integer x){
        myQ[this.depth] = x;
        depth++;
    }

    //end of queue = depth
    //front of queue = max_size - depth

    /**
     * {see IQueue.pop()}
     */
    public Integer pop(){
        //store val at front of queue
        int front = myQ[0];

        //shift values in queue to the left by 1
        for(int i = 0; i < this.MAX_DEPTH - 1; i++){
            myQ[i] = myQ[i + 1];
        }

        //decrement size
        depth--;

        //return old front value
        return front;
    }

    /**
     * {see IQueue.size()}
     */
    public int size(){
        return this.depth;
    }
}