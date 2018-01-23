/**
 SOLUTION: Link List, Math
 NOTES:
 1. code according to the given definition! not to apply LinkedList, but to use the concept of linked list;
 2. l1, l2 is given and cannot be modified, lnode changes all the time, so we use n1, n2, lnode insteas;
 3. sum % 10 is the value, sum / 10 is the carry;
 4. when n1 = null && n2 = null, there might be carry, so add if(sum/10 != 0);
 5. if return lnode, we get [0,...], return lnode.next will get the right answer.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lnode = new ListNode(0);
        ListNode n1 = l1, n2 = l2, ln = lnode;
        int sum = 0;
        while(n1 != null || n2 != null){
            sum /= 10;
            if(n1 != null){
                sum += n1.val;
                n1 = n1.next;
            }
            if(n2 != null){
                sum += n2.val;
                n2 = n2.next;
            }
            ln.next = new ListNode(sum % 10);
            ln = ln.next;
        }
        if(sum/10 != 0) {
            ln.next = new ListNode(sum / 10);
        }
        return lnode.next;
    }
}
