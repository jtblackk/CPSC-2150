package cpsc2150.MyQueue;

/**
 * A queue containing integers.
 * A queue is a data structure where the first item added to the
 structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */

/**
 * IQueue represents a queue (first in = first out data structure)
   The queue contains any data type.
 * Initialization ensures: queue is of size 0
 * Defines:     queue_size: size of queue
 *              MAX_DEPTH: max allowable size of queue
 * Constraints: 0 <= queue_size <= MAX_DEPTH
 */
public interface IQueue<T> {
    int MAX_DEPTH = 100;

    /**
     * @param x value to add to queue
     * @pre queue_size < MAX_DEPTH
     * @post queue_size = #queue_size + 1
     * @post [x added to back of queue]
     */
    public void add(T x);


    /**
     * @return value at the front of the queue
     * @pre queue_size > 0
     * @post queue_size = #queue_size - 1
     * @post [value at front of queue is returned]
     * @post [value at front of queue is removed]
     */
    public T pop();


    /**
     * @return size of queue (# of items in queue)
     * @post [queue_size is returned]
     */
    public int size();

    /**
     * @return integer at the front of the queue
     * @pre queue_size > 0
     * @post [value at front of queue is returned]
     * @post [value at front of queue is not removed from queue]
     */
    default public T peek(){
        T front = this.pop();
        this.insert(front, 1);
        return front;
    }

    /**
     * @return value at the end of the queue
     * @pre queue_size > 0
     * @post [value at end of queue is returned]
     * @post [value at end of queue is not removed from queue]
     */
    default public T endOfQueue(){
        T end = this.remove(this.size());
        this.insert(end, this.size() + 1);
        return end;
    }

    /**
     * @param x value to insert into queue
     * @param pos position in the queue to place value at (indexing starts at 1)
     * @pre 1 <= pos <= queue_size + 1
     * @pre queue_size < MAX_DEPTH
     * @post [x is at position pos in queue]
     */
    default public void insert(T x, int pos){
        // rotate queue for insertion of number
        for(int i = 0; i < pos - 1; i++){
            T front = this.pop();
            this.add(front);
        }

        //add number
        this.add(x);

        //rotate queue to original state
        for(int i = 0; i < this.size() - pos; i++){
            T front = this.pop();
            this.add(front);
        }
    }

    /**
     * @param pos position of the value to remove from the queue (indexing starts at 1)
     * @return value being removed from the queue
     * @pre 1 <= pos <= queue_size
     * @pre queue_size > 0
     * @post queue_size #queue_size - 1
     * @post [value at position pos is removed from the queue]
     * @post [value at position pos in queue is returned]
     */
    default public T remove(int pos){
        // rotate queue for removal of integer
        for(int i = 0; i < pos - 1; i++){
            T front = this.pop();
            this.add(front);
        }

        //remove integer
        T popped = this.pop();;

        //undo rotation
        for(int i = 0; i <= this.size() - pos; i++){
            T front = this.pop();
            this.add(front);
        }
        return popped;
    }

    /**
     * @param pos position of value in queue to get (indexing starts at 1)
     * @return value at position pos in queue
     * @pre 1 <= pos <= queue_size
     * @pre queue_size > 0
     * @post [value at position pos in queue is returned]
     */
    default public T get(int pos){
        T valAtPos = this.remove(pos);
        this.insert(valAtPos, pos);
        return valAtPos;
    }
}
