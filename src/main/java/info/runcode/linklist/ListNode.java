package info.runcode.linklist;

public class ListNode {
	public static ListNode BuildAList(int[] a) {

		ListNode r = null;
		ListNode h = null;
		for (int i = a.length - 1; i >= 0; i--) {
			h = new ListNode(a[i]);
			h.next = r;
			r = h;
		}
		return h;
	}

	public static void PrintAList(ListNode head) {
		ListNode tmp = head;
		while (tmp != null) {
			System.out.print(tmp.val);
			System.out.print("->");
			tmp = tmp.next;
		}
		System.out.println();
	}

	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
}
