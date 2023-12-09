/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head ;
        ListNode turtle = head ;

        if(head == null) return head ;


        while(hare != null && hare.next != null){
            hare = hare.next.next ;
            turtle = turtle.next ;
            if(hare == turtle){
            ListNode node = head ;
                
                while(node != turtle){
                    node = node.next ;
                    turtle = turtle.next ;
                }
            return node ;
            }
        }
        return null ;
    }
}