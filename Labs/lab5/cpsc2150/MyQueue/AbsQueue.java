package cpsc2150.MyQueue;

abstract class AbsQueue implements IQueue{

    //returns a string containing the values in the queue
    public String toString(){
       String  values = "";

       //pop queue, add popped value to string,
        // then add popped value back to queue
       for(int i = 0; i < this.size(); i++) {
           //append front of queue to string
           int front = this.pop();
           values += front;
           this.add(front);

           //if front != last item in the queue : append comma and space
           if(i < this.size() - 1){
               values += ", ";
           }
       }

       return values;
    }
}
