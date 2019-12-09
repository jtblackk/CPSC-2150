package cpsc2150.MyQueue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestListQueue {

    //----------------------IQueue.add tests----------------------//


    /**
     * test 1: adding to an empty queue
     *
     * pre: queue = <>
     * operation: queue.add(4)
     * post: queue = <4>
     */
    @Test
    public void testAdd_empty_doAdd(){
        //pre
        IQueue<Integer> queue = MakeQueue();

        //operation
        queue.add(4);

        //post
        assertTrue(queue.toString().equals("4"));
    }


    /**
     * test 2: adding to a non-empty, non-full queue
     *
     * pre: queue = <1>
     * operation: queue.add(2)
     * post: queue = <1, 2>
     */
    @Test
    public void testAdd_notEmpty_notFull_doAdd(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);

        //operation
        queue.add(2);

        //post
        assertTrue(queue.toString().equals("1, 2"));
    }


    /**
     * test 3: adding to a queue to create a full queue
     * tests the precondition queue_size < MAX_DEPTH
     *
     * pre: queue.getSize = IQueue.MAX_DEPTH - 1
     * operation: queue.add(1)
     * post: queue.getSize = IQueue.MAX_DEPTH
     */
    @Test
    public void testAdd_full_dontAdd(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        for(int i = 1; i < IQueue.MAX_DEPTH; i++){
            queue.add(i);
        }

        //operation
        queue.add(1);

        //post
        assertTrue(queue.size() == IQueue.MAX_DEPTH);
    }



    //----------------------IQueue.peek tests----------------------//


    /**
     * test 1: peek does not change the size of the queue
     *
     * pre: queue = <1, 2>
     * operation: queue.peek()
     * post: queue.getSize = 2
     */
    @Test
    public void testPeek_dontChangeSize(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);

        //operation
        Integer returned = queue.peek();

        //post
        assertTrue(queue.size() == 2);
    }


    /**
     * test 2: peek returns the front of the queue
     *
     * pre: queue = <1, 2>
     * operation: queue.peek()
     * post: queue.peek = 1
     */
    @Test
    public void testPeek_returnsFront(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);

        //operation
        Integer returned = queue.peek();

        //post
        assertTrue(returned == 1);
    }


    /**
     * test 3: peek does not change the order of the queue
     *
     * pre: queue = <1, 2>
     * operation: queue.peek()
     * post: queue = <1, 2>
     */
    @Test
    public void testPeek_preservesOrderOfOriginalQueue() {
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);

        //operation
        Integer returned = queue.peek();

        //post
        assertTrue(queue.toString().equals("1, 2"));
    }



    //----------------------IQueue.endOfQueue tests----------------------//


    /**
     * test 1: endOfQueue does not change the size of the queue
     *
     * pre: queue = <1, 2>
     * operation: queue.endOfQueue()
     * post: queue.getSize = 2
     */
    @Test
    public void testEndOfQueue_dontChangeSize(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);

        //operation
        Integer returned = queue.endOfQueue();

        //post
        assertTrue(queue.size() == 2);
    }


    /**
     * test 2: endOfQueue returns the end of the queue
     *
     * pre: queue = <1, 2>
     * operation: queue.endOfQueue()
     * post: queue.endOfQueue = 2
     */
    @Test
    public void testEndOfQueue_returnsEnd(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);

        //operation
        Integer returned = queue.endOfQueue();

        //post
        assertTrue(returned == 2);
    }


    /**
     * test 3: endOfQueue does not change the order of the queue
     *
     * pre: queue = <1, 2>
     * operation: queue.endOfQueue()
     * post: queue = <1, 2>
     */
    @Test
    public void testEndOfQueue_preservesOrderOfOriginalQueue(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);

        //operation
        Integer returned = queue.endOfQueue();

        //post
        assertTrue(queue.toString().equals("1, 2"));
    }



    //----------------------IQueue.insert tests----------------------//


    /**
     * test 1: insert at front of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.insert(0, 1)
     * post: queue = <0, 1, 2, 3>
     */
    @Test
    public void testInsert_insertAtFront(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        queue.insert(0, 1);

        //post
        assertTrue(queue.toString().equals("0, 1, 2, 3"));
    }


    /**
     * test 2: insert at middle of queue
     * pre: queue = <1, 2, 4>
     * operation: queue.insert(3, 3)
     * post: queue = <1, 2, 3, 4>
     */
    @Test
    public void testInsert_insertAtMiddle(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(4);

        //operation
        queue.insert(3, 3);

        //post
        assertTrue(queue.toString().equals("1, 2, 3, 4"));
    }


    /**
     * test 3: insert at end of queue
     * pre: queue = <1, 2, 3>
     * operation: queue.insert(4, 4)
     * post: queue = <1, 2, 3, 4>
     */
    @Test
    public void testInsert_insertAtEnd(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        queue.insert(4, 4);

        //post
        assertTrue(queue.toString().equals("1, 2, 3, 4"));
    }



    //----------------------IQueue.remove tests----------------------//


    /**
     * test 1: remove front of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.remove(1)
     * post: queue = <2, 3>
     */
    @Test
    public void testRemove_removeFront(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.remove(1);

        //post
        assertTrue(queue.toString().equals("2, 3"));
    }


    /**
     * test 2: remove middle of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.remove(2)
     * post: queue = <1, 3>
     */
    @Test
    public void testRemove_removeMiddle(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.remove(2);

        //post
        assertTrue(queue.toString().equals("1, 3"));
    }


    /**
     * test 3: remove end of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.remove(3)
     * post: queue = <1, 2>
     */
    @Test
    public void testRemove_removeEnd(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.remove(3);

        //post
        assertTrue(queue.toString().equals("1, 2"));
    }

    /**
     * test 4: returns value that was removed
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.remove(2)
     * post: queue.remove(2) = 2
     */
    @Test
    public void testRemove_returnsRemoved(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.remove(2);

        //post
        assertTrue(returned == 2);
    }



    //----------------------IQueue.get tests----------------------//


    /**
     * test 1: get front of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.get(1)
     * post: queue.get = 1
     */
    @Test
    public void testGet_getFront(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.get(1);

        //post
        assertTrue(returned == 1);
    }


    /**
     * test 2: get middle of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.get(2)
     * post: queue.get = 2
     */
    @Test
    public void testGet_getMiddle(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.get(2);

        //post
        assertTrue(returned == 2);
    }


    /**
     * test 3: get end of queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.get(3)
     * post: queue.get = 3
     */
    @Test
    public void testGet_getEnd(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.get(3);

        //post
        assertTrue(returned == 3);
    }


    /**
     * test 4: ensure get does not change the original queue
     *
     * pre: queue = <1, 2, 3>
     * operation: queue.get(2)
     * post: queue = <1, 2, 3>
     */
    @Test
    public void testGet_preservesOriginalQueue(){
        //pre
        IQueue<Integer> queue = MakeQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //operation
        Integer returned = queue.get(2);

        //post
        assertTrue(queue.toString().equals("1, 2, 3"));

    }



    //----------------------helper functions----------------------//

    //returns an IQueue<Integer> with dynamic type ListQueue<Integer>
    private IQueue<Integer> MakeQueue(){
        IQueue<Integer> queue = new ListQueue<Integer>();
        return queue;
    }
}
