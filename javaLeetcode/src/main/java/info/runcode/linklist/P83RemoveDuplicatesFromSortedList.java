package info.runcode.linklist;

import info.runcode.linklist.ListNode;

public class P83RemoveDuplicatesFromSortedList {
//	83. Remove Duplicates from Sorted List
//	Easy
//	591
//	64
//
//
//	Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//	Example 1:
//
//	Input: 1->1->2
//	Output: 1->2
//	Example 2:
//
//	Input: 1->1->2->3->3
//	Output: 1->2->3
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode t = head;
		int c = 0;
		if (head==null) {
			return null;
		}else {
			c = t.val;
		}
		ListNode h = t;
		t = t.next;
		while (t!=null) {
			if (c == t.val) {
				//h.next = t.next;
			}else {
				c = t.val;
				h.next = t;
				h = t;
			}
			t = t.next;
		}
		h.next = null;
		return head;
        
    }
	
	public static void main(String[] args) {
		P83RemoveDuplicatesFromSortedList a = new P83RemoveDuplicatesFromSortedList();
    	int[] head = {0,1,1,1,1,1,3,10,10,5}; // {0,1,2}; {2,1,0};
    	
    	ListNode h = ListNode.BuildAList(head);
    	ListNode.PrintAList(h);
    	
    	ListNode r = a.deleteDuplicates(h);
    	ListNode.PrintAList(r);
    }
}
