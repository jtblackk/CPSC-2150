/*
 * Jeffrey Black
 * jtblack@clemson.edu
 * CPSC 2151
 */

package cpsc2150.MyQueue;

import java.lang.reflect.Array;
import java.util.Scanner;

public class QueueApp {
    public static void main(String args[]){
        IQueue q;

        //ask user for implementation type and store choice
        Scanner scan = new Scanner(System.in);
        System.out.println("for array implementation, enter 0");
        System.out.println("for list implementation, enter 1");
        System.out.print("choice: ");
        int choice = scan.nextInt();

        //initialize queue (q)
        if(choice == 0){
            q = new ArrayQueue();
        }
        else{
            q = new ListQueue();
        }


        Integer x = 42;
        q.add(x);
        x = 17;
        q.add(x);
        x = 37;
        q.add(x);
        x = 36;
        q.add(x);
        x = 12;
        q.add(x);


        //print out all values in myQ while preserving the queue
        for(int i = 0; i < q.size(); i++){
            int front = q.pop();
            System.out.print(front + " ");
            q.add(front);
        }
        System.out.println();
    }

}
