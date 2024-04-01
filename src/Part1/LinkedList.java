package Part1;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        public int value;
        public Node next;
        public Node(){

        }

        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;

    private int size;

    private boolean isEmpty(){
        return first == null;
    }



    public void addLast(int value){
        var node = new Node(value);

        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value){
        var node = new Node(value);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public void deleteFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(first == last)
            first = last = null;
        else{
            var previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node){
        Node current = first;
        while(current != null){
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }
    public void print(){
        Node node = first;
        while (node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }
    public int indexOf(int value){
        Node node = first;
        int index = 0;
        while(node != null){
            if(node.value == value)
                return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if(isEmpty())
            return;
        Node previous = first;
        Node current = first.next;

        while(current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public void middle(){
        if(isEmpty())
            throw new IllegalStateException();

        var slow = first;
        var fast = first;
        int count = 1;

        while(fast.next != null){
            if(count % 2 != 0)
                slow = slow.next;
            fast = fast.next;
            count++;
        }
        System.out.println(slow.value);
        if(count % 2 == 0)
            System.out.println(slow.next.value);
    }

    public void getKthFromTheEnd(int k){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        var lead = first;
        var follow = first;

        for(int i = 0; i < k - 1; i++){
            lead = lead.next;
            if(lead == null){
                throw new IllegalArgumentException();
            }
        }
        while(lead != last){
            follow = follow.next;
            lead = lead.next;
        }
        System.out.println(follow.value);
    }
    public void printMiddle(){
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        var slow = first;
        var fast = first;

        int count = 1;
        while(fast.next != null){
            fast = fast.next;
            if(count % 2 == 0)
                slow = slow.next;
            count++;
        }
        System.out.println(slow.value);
        if(count % 2 == 0){
            System.out.println(slow.next.value);
        }
    }
    public boolean hasLoop(){
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        var slow = first;
        var fast = first;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
        public Node removeElements(Node head, int val) {
            Node current = head;
            Node previous = null;

            while(current != null){
                Node next = current.next;

                if(current.value == val) {
                    if (previous == null)
                        head = next;
                    else
                        previous.next = next;
                    current.next = null;
                }
                previous = current;
                current = next;

            }
            return head;

        }
}
