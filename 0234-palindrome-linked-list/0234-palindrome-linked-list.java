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
    public ListNode reverse(ListNode head){
            if(head == null || head.next == null){
                return head ;
            }
            ListNode prevNode = head ;
            ListNode currNode = head.next ;
            while(currNode != null){
                ListNode nextNode = currNode.next; 
                currNode.next = prevNode ;
                prevNode = currNode;
                currNode = nextNode;
            }
            head.next = null ;
            head = prevNode ;
            return head;
        }

        public ListNode findMiddle(ListNode head){
            ListNode hare = head ;
            ListNode turtle = head;
            while(hare.next != null && hare.next.next != null){   
                hare = hare.next.next;
                turtle = turtle.next;
            }
            return turtle;
        }    
        
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);

        ListNode firstHalf = head ;
        while(secondHalfStart != null){
            if(firstHalf.val != secondHalfStart.val){
                return false ;
            }
            firstHalf = firstHalf.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
}