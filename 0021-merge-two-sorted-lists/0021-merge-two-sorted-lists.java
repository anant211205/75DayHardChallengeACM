/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertLast(ListNode head ,int val){
        ListNode node = new ListNode(val);
        if(head == null){
            return node ;
        }
        ListNode curr = head ;
        while(curr.next != null){
            curr = curr.next ;
        }
        curr.next = node ;
        return head ;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2 ){
        ListNode H1 = list1 ;
        ListNode H2 = list2 ;

        ListNode LL = null ;
        while(H1 != null && H2 != null){
            if(H1.val < H2.val){
                LL = insertLast(LL,H1.val);
                H1 = H1.next ;
            }else{
                LL = insertLast(LL, H2.val);
                H2 = H2.next ;
            }
        }
        while(H1 != null){
            LL = insertLast(LL , H1.val);
                H1 = H1.next ;
        }
        while(H2 != null){
            LL = insertLast(LL , H2.val);
                H2 = H2.next ;
        }
        return LL ;
    }
}

