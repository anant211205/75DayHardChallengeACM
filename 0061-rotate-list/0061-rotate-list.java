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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){  //corner case..
            return head ;
        }
        int n = 1 ;  //for counting no. of nodes in list
        ListNode temp = head ;
        while(temp.next != null){
            temp = temp.next; 
            n++ ;
        }
        temp.next = head ; //pointing last node to head..

        int i = n - k % n ;  //% n because rotating 4 times means rotating 1 time when no. of nodes is 3 ...
        while(i > 0){  //actual number of positions to rotate
            temp = temp.next ;
            i-- ;
        }
        ListNode returnHead = temp.next ; //new head..
        temp.next = null ;
        return returnHead ;
    }
}