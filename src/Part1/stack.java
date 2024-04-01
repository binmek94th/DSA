package Part1;

import java.util.Arrays;

public class stack {
    private int[] stack;
    private int size = 0;


    public stack(){
        stack = new int[4];
    }

    public void push(int value){
        if(stack.length == size){
            int[] temp = new int[size * 2];
            for(int i = 0; i < size; i++){
                temp[i] = stack[i];
            }
            stack = temp;
        }
        stack[size++] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return stack[--size];
    }

    @Override
    public String toString(){
        int[] content = Arrays.copyOfRange(stack, 0, size);
        return Arrays.toString(content);
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return stack[size - 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
