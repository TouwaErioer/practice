package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author: chobit
 * @created: 2021/08/02 11:30
 */
public class No234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode front;

    public boolean isPalindrome(ListNode head) {
        front = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode){
        if(currentNode != null){
            if(!recursivelyCheck(currentNode.next)){
                return false;
            }
            if(currentNode.val != front.val){
                return false;
            }
            front = front.next;
        }
        return true;
    }
}
