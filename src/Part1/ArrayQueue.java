package Part1;

import java.util.Arrays;
import java.util.Stack;

public class ArrayQueue {
    private int[] array;
    private int size, front, rear;

    public ArrayQueue(int capacity){
        array = new int[capacity];
    }
    public void enqueue(int value){
        if(isFull())
            throw new IllegalStateException();
        array[rear] = value;
        rear = (rear + 1) % array.length;
        size++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        size--;
        return item;

    }

    public boolean isEmpty(){
        return front == size;
    }

    public boolean isFull(){
        return array.length == size;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    public void reverse(int k){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++){
            stack.push(array[i]);
        }
        for (int i = 0; i < k; i++){
            array[i] = stack.pop();
        }
    }
}
