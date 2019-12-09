package cpsc2150.MyQueue;

/**
 * A queue containing integers.
 * A queue is a data structure where the first item added to the
 structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */

/**
 * IQueue represents a queue (first in = first out data structure)
   The queue contains integers.
 * Initialization ensures: Integer queue is of size 0
 * Defines:     queue_size: size of queue
 *              MAX_DEPTH: max allowable size of queue
 * Constraints: 0 <= queue_size <= MAX_DEPTH
 */
public interface IQueue {
    int MAX_DEPTH = 100;

    /**
     * @param x number to add to queue
     * @post x added to back of queue
     * @post queue_size = #queue_size + 1
     */
    public void add(Integer x);


    /**
     * @return integer at the front of the queue
     * @pre queue_size > 0
     * @post value at front of queue is returned
     * @post value at front of queue is removed
     * @post queue_size = #queue_size - 1
     */
    public Integer pop();


    /**
     * @return size of queue (# of integers)
     * @post queue_size is returned
     */
    public int size();
}