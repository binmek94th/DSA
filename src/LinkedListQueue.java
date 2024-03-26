public class LinkedListQueue {
    //enqueue
    //dequeue
    //peek
    //size
    //isEmpty
    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    Node first;
    Node last = first;
    int size = 0;

    public void enqueue(int value){
        if (isEmpty()){
            Node node = new Node(value);
            first = node;
            last = node;
        }
        else{
            Node node = new Node(value);
            last.next = node;
            last = node;
        }
        size++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();

        Node temp = first;
        first = first.next;
        size--;
        return temp.value;
    }

    public int peek(){
        return first.value;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public static void reverse(LinkedListQueue queue){
        stack stack = new stack();
        while (!queue.isEmpty())
            stack.push(queue.dequeue());
        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
    }
}

