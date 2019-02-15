package info.runcode.linklist;

public class P92ReverseLinkedListII {
//	92. Reverse Linked List II
//	Medium
//
//	960
//
//	72
//
//	Favorite
//
//	Share
//	Reverse a linked list from position m to n. Do it in one-pass.
//
//	Note: 1 ¡Ü m ¡Ü n ¡Ü length of list.
//
//	Example:
//
//	Input: 1->2->3->4->5->NULL, m = 2, n = 4
//	Output: 1->4->3->2->5->NULL
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) return head;
		if (m>=n) return head;
		if (head.next==null) return head;
		
		ListNode th = head;
		int i = 1;
		ListNode pre = null,prepre=null,t=null,h=null, inner = null,nextth=th;
		while(true) {
			nextth = th.next;
			if(i==m) {
				t = th;
				inner = t;
				t.next = null;
				prepre = pre;
			}
			if(i==n) {
				h = th;
				th.next = inner;
				if (prepre!=null) {
					prepre.next = h;
				}else {
					head = th;
				}
			}
			if (i== n+1) {
				t.next = th;
			}
			if((i>m)&&(i<n)) {
				th.next = inner;
				inner = th;
			}
			pre = th;
			th = nextth;
            i++;
            if (th==null) break;
		}
		return head;
        
    }
	
	public static void main(String[] args) {
		P92ReverseLinkedListII p = new P92ReverseLinkedListII();
		ListNode head = ListNode.BuildAList(new int[] {3,1,2,4});
		int m=2;
		int n=4;
		ListNode res = p.reverseBetween(head, m, n);
		ListNode.PrintAList(res);
	}
}
