import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{7,7,7,7};
        int[] arr2 = new int[]{2,3};
        ListNode headA = null;
        ListNode currentA = null;
        ListNode headB = null;
        ListNode currentB = null;
        for (int i = 0; i < arr1.length; i++){
            if (headA == null){
                headA = new ListNode(arr1[i]);
                currentA = headA;
                continue;
            }
            currentA.next = new ListNode(arr1[i]);
            currentA = currentA.next;
        }
        for (int i = 0; i < arr2.length; i++){
            if (headB == null){
                headB = new ListNode(arr2[i]);
                currentB = headB;
                continue;
            }
            currentB.next = new ListNode(arr2[i]);
            currentB = currentB.next;
        }
        LinkedListExercise exercise = new LinkedListExercise();
        var result = exercise.removeElements(headA, 7);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

