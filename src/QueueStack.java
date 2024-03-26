public class QueueStack {
    private LinkedListQueue queue1 = new LinkedListQueue();
    private LinkedListQueue queue2 = new LinkedListQueue();
    int size = 0;
    int top;

    public void push(int value){
        queue1.enqueue(value);
        size++;
    }

    public int pop(){
        if (queue1.isEmpty()) throw new IllegalStateException();

        while (queue1.size > 1){
            top = queue1.dequeue();
            queue2.enqueue(top);
        }

        swapQueues();

        return queue2.dequeue();
    }

    public void swapQueues(){
        LinkedListQueue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int peek(){
        if (queue1.isEmpty()) throw new IllegalStateException();

        return top;
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }

    public int size(){
        return size;
    }



}
