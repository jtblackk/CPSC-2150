default: cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/StringQueueApp.java cpsc2150/MyQueue/AbsQueue.java
	javac -Xlint cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/StringQueueApp.java cpsc2150/MyQueue/AbsQueue.java

runInt: cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/QueueApp.class cpsc2150/MyQueue/AbsQueue.class
	java cpsc2150.MyQueue.QueueApp

runString: cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/StringQueueApp.class cpsc2150/MyQueue/AbsQueue.class
	java cpsc2150.MyQueue.StringQueueApp

clean: cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/QueueApp.class cpsc2150/MyQueue/StringQueueApp.class cpsc2150/MyQueue/AbsQueue.class
	rm cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/QueueApp.class cpsc2150/MyQueue/StringQueueApp.class cpsc2150/MyQueue/AbsQueue.class

test: cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/StringQueueApp.java cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/TestArrayQueue.java cpsc2150/MyQueue/TestListQueue.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/StringQueueApp.java cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/TestArrayQueue.java cpsc2150/MyQueue/TestListQueue.java

testArr: cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/QueueApp.class cpsc2150/MyQueue/StringQueueApp.class cpsc2150/MyQueue/AbsQueue.class cpsc2150/MyQueue/TestArrayQueue.class cpsc2150/MyQueue/TestListQueue.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyQueue.TestArrayQueue

testList: cpsc2150/MyQueue/ArrayQueue.class cpsc2150/MyQueue/IQueue.class cpsc2150/MyQueue/ListQueue.class cpsc2150/MyQueue/QueueApp.class cpsc2150/MyQueue/StringQueueApp.class cpsc2150/MyQueue/AbsQueue.class cpsc2150/MyQueue/TestArrayQueue.class cpsc2150/MyQueue/TestListQueue.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyQueue.TestListQueue

