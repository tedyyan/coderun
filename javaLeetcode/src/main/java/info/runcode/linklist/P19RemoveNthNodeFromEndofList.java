package info.runcode.linklist;

public class P19RemoveNthNodeFromEndofList {
//	19. Remove Nth Node From End of List
//	Medium
//
//	1462
//
//	114
//
//	Favorite
//
//	Share
//	Given a linked list, remove the n-th node from the end of list and return its head.
//
//	Example:
//
//	Given linked list: 1->2->3->4->5, and n = 2.
//
//	After removing the second node from the end, the linked list becomes 1->2->3->5.
//	Note:
//
//	Given n will always be valid.
//
//	Follow up:
//
//	Could you do this in one pass?
	
	// Its difficulty is normal, how to find the 
	//TODO  need to improve
//	Runtime: 8 ms, faster than 22.64% of Java online submissions for Remove Nth Node From End of List.
//	Memory Usage: 27.1 MB, less than 55.75% of Java online submissions for Remove Nth Node From End of List.

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode beforeremove = null;
		ListNode remove = head;
		ListNode cur = head;
		int i=1;
		while(cur!=null) {
			if (i==n) {
				remove = head;
			}else if(i>n) {
				remove = remove.next;
			}
			if (i==n+1) {
				beforeremove = head;
			}else if(i>n+1) {
				beforeremove = beforeremove.next;
			}
			cur = cur.next;	
			i++;
		}
		if (beforeremove==null) {
			head = remove.next;
		}else {
			beforeremove.next = remove.next;			
		}
		return head;
	}
}
