package info.runcode.linklist;

public class P86PartitionList {
//	86. Partition List
//	Medium
//
//	541
//
//	145
//
//	Favorite
//
//	Share
//	Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//	You should preserve the original relative order of the nodes in each of the two partitions.
//
//	Example:
//
//	Input: head = 1->4->3->2->5->2, x = 3
//	Output: 1->2->2->4->3->5
	
	
	public ListNode partition(ListNode head, int x) {
		if(head==null) return null;
		ListNode orginalHead = head;
		ListNode leftHead = null;
		ListNode leftEnd = null;
		ListNode rightHead = null;
		ListNode rightEnd = null;
		while(head!=null) {
			ListNode tmp = head;
			head = head.next;
			if (tmp.val >= x) {
				if(rightHead==null) {
					rightHead = tmp;	
					rightEnd = tmp;
				}else {
					rightEnd.next = tmp;
					rightEnd = tmp;
				}
			}else {
				if(leftHead==null) {
					leftHead = tmp;	
					leftEnd = tmp;
				}else {
					leftEnd.next = tmp;
					leftEnd = tmp;
				}
			}			
		}
		if(leftEnd==null) {
			rightEnd.next = null;
			return rightHead;
		}
		if(rightEnd==null) {
			leftEnd.next = null;
			return leftHead;
		}
		leftEnd.next = rightHead;
		rightEnd.next = null;
		return leftHead;
        
    }
	 public static void main(String[] args) {
		 P86PartitionList a = new P86PartitionList();
	    	int[] head = {1,1}; // {0,1,2}; {2,1,0};[1,4,3,2,5,2]
	    	
	    	int k = 0;
	    	ListNode h = ListNode.BuildAList(head);
	    	ListNode.PrintAList(h);
	    	
	    	ListNode r = a.partition(h, k);
	    	ListNode.PrintAList(r);
	    }
	 public ListNode partition2(ListNode head, int x) {
			
			ListNode orginalHead = head;
			ListNode leftHead = null;
			ListNode leftEnd = null;
			ListNode rightHead = null;
			ListNode rightEnd = null;
			ListNode midHead = null;
			ListNode midEnd = null;
			while(head!=null) {
				ListNode tmp = head;
				head = head.next;
				if (tmp.val > x) {
					if(rightHead==null) {
						rightHead = tmp;	
						rightEnd = tmp;
					}else {
						rightEnd.next = tmp;
						rightEnd = tmp;
					}
				}else if(tmp.val == x){
					if(midHead==null) {
						midHead = tmp;	
						midEnd = tmp;
					}else {
						midHead.next = tmp;
						midEnd = tmp;
					}
				}else {
					if(leftHead==null) {
						leftHead = tmp;	
						leftEnd = tmp;
					}else {
						leftEnd.next = tmp;
						leftEnd = tmp;
					}
				}			
			}
			leftEnd.next = midHead;
			midEnd.next = rightHead;
			rightEnd.next = null;
			return leftHead;
	        
	    }
}
