package info.runcode.linklist;

public class P143ReorderList {
//	143. Reorder List
//	Medium
//	624
//	53
//	Favorite
//	Share
//	Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
//	reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
//
//	You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//	Example 1:
//
//	Given 1->2->3->4, reorder it to 1->4->2->3.
//	Example 2:
//
//	Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
	
	public void reorderList(ListNode head) {
		
	}
	
	public ListNode reverse(ListNode head){
		ListNode iter = head;
		ListNode tmp = null;
		while(iter!=null) {
			tmp = iter.next;
			if (tmp==null)
				break;
			ListNode ne = tmp.next ;
			tmp.next = iter;
		}
		return tmp;
	}
}
