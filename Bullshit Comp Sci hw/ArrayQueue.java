import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    // Constants
    public final int INITIAL_SIZE = 10;

    // Instance variables
    private E[] array;
    private int size; // Logical size
    private int front; // Index of the front of the queue
    private int rear; // Index of the rear of the queue

    @SuppressWarnings({"unchecked"})
    public ArrayQueue() {
        array = (E[]) new Object[INITIAL_SIZE];
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public void enqueue(E item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + item);
            return;
        }
        array[rear] = item;
        rear = (rear + 1) % array.length; // Circular increment
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        E item = array[front];
        front = (front + 1) % array.length; // Circular increment
        size--;
        return item;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element.");
            return null;
        }
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty!";
        }
        StringBuilder sb = new StringBuilder();
        int index = front;
        for (int i = 0; i < size; i++) {
            sb.append(array[index]).append(" ");
            index = (index + 1) % array.length; // Circular increment
        }
        return sb.toString().trim();
    }
}
