public class StackQueue {
    stack first = new stack();
    stack second = new stack();

    public void enqueue(int value){
        first.push(value);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack();

        return second.pop();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack();

        return second.peek();
    }

    private void moveStack() {
        if(second.isEmpty())
            while(!first.isEmpty())
                second.push(first.pop());
    }

    public boolean isEmpty(){
        return first.isEmpty() && second.isEmpty();
    }


}
