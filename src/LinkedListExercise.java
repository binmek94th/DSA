
public class LinkedListExercise {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        int sizeA = calculateLength(headA);
        int sizeB = calculateLength(headB);
        int difference = Math.abs(sizeA - sizeB);

        if (sizeA == sizeB){
            if (currentA.val == currentB.val){
                return currentB;
            }
        }

        if (sizeA > sizeB){
            while (difference != 0){
                currentA = currentA.next;
                difference--;
            }
        }

        if (sizeA < sizeB){
            while (difference != 0){
                currentB = currentB.next;
                difference--;
            }
        }
        while (currentA != null && currentB != null){
            if (currentA.val == currentB.val)
                 return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }


        return null;
    }
    public int calculateLength(ListNode node){
        int count = 0;
        while (node != null){
            node = node.next;
            count++;
        }
        return count;
    }
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null){
            fast = fast.next;
            if (count % 2 == 0) slow = slow.next;
            count++;
        }
        if (count % 2 == 0) return slow.next;
        return slow;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null){
            ListNode next = current.next;
            if (current.val == val) {
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
