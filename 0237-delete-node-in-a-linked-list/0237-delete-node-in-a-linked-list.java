/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //it is given that node.next cannot be null...
        node.val = node.next.val; 
        node.next = node.next.next ;
    }
}