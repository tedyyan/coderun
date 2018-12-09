package info.runcode.linklist;

public class P61 {
	/**
	 * 
	 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
	 * 
	 * @author yanxuan
	 *
	 */
	public class ListNode {
		      int val;
		      ListNode next;
		     ListNode(int x) { val = x; }
	}
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public ListNode rotateRight(ListNode head, int k) {
	       ListNode tmp = head;
	    	int rk = 0;
	    	while(tmp!=null) {
	    		rk++;
	    		tmp=tmp.next;
	    	}
	    	if ((rk==0)||(rk==1)||k==0) return head;
	    	k = k % rk;
	    	tmp = head;
	    	for (int i=0;i<k;i++) {        	
	        	ListNode before_tmp = head;
	        	while(tmp.next!=null) {
	        		before_tmp = tmp;
	        		tmp=tmp.next;
	        	}
	        	before_tmp.next = null;
	        	tmp.next = head;
	        	head = tmp;
	    	}    	
			return head;	
	        
	        
	    }
	
    public static void main(String[] args) {
    	P61 a = new P61();
    	int[] head = {0,1,2}; // {0,1,2}; {2,1,0};
    	
    	int k = 4;
    	ListNode h = a.BuildAList(head);
    	a.PrintAList(h);
    	
    	ListNode r = a.rotateRight(h, k);
    	a.PrintAList(r);
    }
    
    public ListNode BuildAList(int[] a){
    	ListNode r = null;
    	ListNode h = null;
    	for(int i=a.length-1;i>=0;i--) {
    		h = new ListNode(a[i]);
    		h.next = r;
    		r = h;
    	}
    	return h;
    }
    
    public void PrintAList(ListNode head){
    	ListNode tmp = head;
    	while(tmp!=null) {
    		System.out.print(tmp.val);
    		System.out.print("->");
    		tmp=tmp.next;
    	}
    	System.out.println();
    }
}
