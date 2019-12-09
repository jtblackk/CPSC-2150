/*
 * Jeffrey Black
 * jtblack@clemson.edu
 * CPSC 2151
 */

//builds a queue and lets the user perform manipulations and retrieve
//data about the queue

package cpsc2150.MyQueue;

import java.util.Scanner;

public class QueueApp {
    public static void main(String args[]){
        IQueue<Integer> q;

        //ask user for implementation type and store choice
        Scanner scan = new Scanner(System.in);
        System.out.println("for array implementation, enter 0");
        System.out.println("for list implementation, enter 1");
        System.out.print("choice: ");
        int choice = scan.nextInt();

        //initialize queue
        if(choice == 0){
            q = new ArrayQueue<Integer>();
        }
        else{
            q = new ListQueue<Integer>();
        }

        boolean exit = false;
        while(exit == false) {
            //print menu
            printMenu();

            //take in user choice
            int menuChoice;
            choice = scan.nextInt();

            //perform action specified by choice
            switch(choice){
                case 1:
                    System.out.println("What number to add to the queue?");
                    int val = scan.nextInt();
                    q.add(val);
                    break;
                case 2:
                    if(q.size() < 1){
                        System.out.println("Queue is empty. make another choice.");
                    }
                    else{
                        System.out.println("Next number is " + q.pop());
                    }
                    break;
                case 3:
                    if(q.size() < 1){
                        System.out.println("Queue is empty. make another choice.");
                    }
                    else{
                        System.out.println("Peek: " + q.peek());
                    }
                    break;
                case 4:
                    if(q.size() < 1){
                        System.out.println("Queue is empty. make another choice.");
                    }
                    else{
                        System.out.println("Peek at end: " + q.endOfQueue());
                    }
                    break;
                case 5:
                    if(q.size() >= IQueue.MAX_DEPTH){
                        System.out.println("Queue is too large. remove some values before inserting more.");

                    }
                    else {
                        System.out.println("what value to insert into the queue?");
                        val = scan.nextInt();
                        System.out.println("where to insert value in the queue?");
                        int where = scan.nextInt();
                        while(where < 1 || where > q.size() + 1){
                            System.out.println("invalid location. please try another location.");
                            where = scan.nextInt();
                        }
                        q.insert(val, where);
                    }
                    break;
                case 6:
                    if(q.size() < 1){
                        System.out.println("Queue is empty. make another choice.");
                    }
                    else {
                        System.out.println("which value in queue to get?");
                        int where = scan.nextInt();
                        while (where < 1 || where > q.size()) {
                            System.out.println("invalid location. please try another location.");
                            where = scan.nextInt();
                        }
                        System.out.println(q.get(where) + " was at position " + where + " in the queue");
                    }
                    break;
                case 7:
                    if(q.size() < 1){
                        System.out.println("Queue is empty. make another choice.");
                    }
                    else {
                        System.out.println("which value in queue to remove?");
                        int where = scan.nextInt();
                        while (where < 1 || where > q.size()) {
                            System.out.println("invalid location. please try another location.");
                            where = scan.nextInt();
                        }
                        System.out.println("removed " + q.remove(where) + " from position " + where + " in the queue");
                    }
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("invalid option. try again.");
                    break;
            }

            //print state of queue
            System.out.println("Queue is:");
            System.out.println(q.toString());
        }
    }

    //prints out the menu options
    public static void printMenu(){
        System.out.println("1. Add to the queue");
        System.out.println("2. Get the next number from the queue");
        System.out.println("3. Peek at the first value in the queue");
        System.out.println("4. Peek at the last value in the queue");
        System.out.println("5. Insert into a position in the queue");
        System.out.println("6. Peek at a value in any position in the queue");
        System.out.println("7. Remove a value from any position in the queue and return it");
        System.out.println("8. Exit");
    }
}
