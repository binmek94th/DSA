package Part1.Check;

public class LinkedList{

    private class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    Node head;
    Node tail = head;

    public int count;

    public boolean isEmpty(){
        return head != null;
    }
    public void addFirst(int value){
        Node node = new Node(value);
        if (!isEmpty()) {
            head = tail = node;
        }
        else {
            node.next = head;
            head = node;
        }
        count++;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if (!isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public void removeFirst() {
        if (!isEmpty()) throw new IllegalStateException();
        if (head == tail){
            head = tail = null;
        }
        else {
            Node node = head.next;
            head.next = null;
            head = node;
        }
        count--;
    }

    public void removeLast() {
        if (!isEmpty()) throw new IllegalStateException();
        if (head == tail){
            head = tail = null;
        }
        else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
        count--;
    }

    public int indexOf(int value) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.val == value){
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public int size(){
        return count;
    }

    public int[] toArray(){
        Node current = head;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++){
            arr[i] = current.val;
            current = current.next;
        }

        return arr;
    }

    public void reverse(){
        if (!isEmpty()) return;

        Node previous = null;
        Node current = head;

        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        tail = head;
        tail.next = null;
        head = previous;
    }

    public void removeAllOccurrence(int value){
        if (!isEmpty()) return;
        Node current = head;
        Node previous = null;

        while (current != null) {
            Node next = current.next;
            if (current.val == value){
                if (current == head) {
                    head = next;
                    current.next = null;
                    current = next;
                    count--;
                }
                else {
                    previous.next = next;
                    current.next = null;
                    current = next;
                    count--;
                }
            }
            else {
                previous = current;
                current = next;
            }
        }
        tail = previous;
        if(!isEmpty()) tail = null;
    }

}
