package info.runcode.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class P704 {
	// PriorityQueue
	/*
	 * Design a class to find the kth largest element in a stream. Note that it is
	 * the kth largest element in the sorted order, not the kth distinct element.
	 * 
	 * Your KthLargest class will have a constructor which accepts an integer k and
	 * an integer array nums, which contains initial elements from the stream. For
	 * each call to the method KthLargest.add, return the element representing the
	 * kth largest element in the stream.
	 * 
	 * Example:
	 * 
	 * int k = 3; 
	 * int[] arr = [4,5,8,2]; 
	 * KthLargest kthLargest = new KthLargest(3,arr); 
	 * kthLargest.add(3); // returns 4 
	 * kthLargest.add(5); // returns 5
	 * kthLargest.add(10); // returns 5 
	 * kthLargest.add(9); // returns 8
	 * kthLargest.add(4); // returns 8
	 */

	public class KthLargest {

		PriorityQueue<Integer> q = null;
		int min = Integer.MAX_VALUE;
		int c = 0;
		public KthLargest(int k, int[] nums) {
//			q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2 - o1;
//				}
//			});
			c = k;
			
			q = new PriorityQueue<Integer>();
			if ((nums !=null) &&(c>0)){
				int c = 0;
				for (int a : nums) {
					if (c>=k) {
						this.add(a);
					}else {
						q.add(a);
					}
					c++;
				}
			}
			
		}

		public int add(int val) {
			if (c<=0) {
				return 0;
			}
			if (q.peek()==null) {
				q.add(val);	
				return q.peek();				
			}
			if (q.size() < c ){
				q.add(val);	
				return q.peek();	
			}
			
			if (q.peek() < val) {
				q.poll();
				q.add(val);				
			}

			return q.peek();
		}

		public int peek() {
			if (q.peek()==null) return 0;
			return q.peek();
		}
	}

	public static void main(String[] args) {
		int k = 2;
		int[] arr = { 0 };
		P704 a = new P704();
		P704.KthLargest kthLargest = a.new KthLargest(k, arr);
		System.out.println(kthLargest.peek());
		System.out.println(kthLargest.add(-1)); // returns 4
		System.out.println(kthLargest.add(1)); // returns 5
		System.out.println(kthLargest.add(-2)); // returns 5
		System.out.println(kthLargest.add(-4)); // returns 8
		System.out.println(kthLargest.add(3)); // returns 8
	}

}
