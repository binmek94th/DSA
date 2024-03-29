import Check.LinkedList;


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(20);
        list.addLast(50);
        list.addLast(20);
        System.out.println(list.count);
        list.removeAllOccurrence(20);
        list.reverse();
        var result = list.toArray();
        for (int j : result) {
            System.out.println(j);
        }
    }
}

