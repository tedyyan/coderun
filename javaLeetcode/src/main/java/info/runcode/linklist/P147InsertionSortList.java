package info.runcode.linklist;

public class P147InsertionSortList {
	
//	147. Insertion Sort List
//	Medium
//
//	295
//
//	358
//
//	Favorite
//
//	Share
//	Sort a linked list using insertion sort.
//
//
//	A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
//	With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
//	 
//
//	Algorithm of Insertion Sort:
//
//	Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
//	At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
//	It repeats until no input elements remain.
//
//	Example 1:
//
//	Input: 4->2->1->3
//	Output: 1->2->3->4
	
//	Runtime: 120 ms, faster than 5.10% of Java online submissions for Insertion Sort List.
//	Memory Usage: 38.1 MB, less than 45.06% of Java online submissions for Insertion Sort List.
	
	public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        
        ListNode tmp = head;
        ListNode pre = null , moveele = null,newhead=null;
        while(tmp!=null){
            ListNode a =  tmp.next; 
            ListNode ele = tmp;
            int elevalue = tmp.val;
            moveele = null;
            while(ele.next!=null){
                ele=ele.next;
                if (ele.val < elevalue){
                    moveele = ele;
                }
            }
            if(moveele!=null){
                tmp.next = moveele.next;
                moveele.next = tmp;
                if(pre!=null)
                    pre.next = a;
            }else{
                if(newhead==null)
                    newhead = tmp;
                pre = tmp;
            }
            tmp = a;  
        }
        return newhead;
    }
}
