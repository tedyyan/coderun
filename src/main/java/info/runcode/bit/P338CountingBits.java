package info.runcode.bit;

public class P338CountingBits {
//	338. Counting Bits
//	Medium
//
//	1062
//
//	75
//
//	Favorite
//
//	Share
//	Given a non negative integer number num. For every numbers i in the range 0 ¡Ü i ¡Ü num calculate the number of 1's in their binary representation and return them as an array.
//
//	Example 1:
//
//	Input: 2
//	Output: [0,1,1]
//	Example 2:
//
//	Input: 5
//	Output: [0,1,1,2,1,2]
//	Follow up:
//
//	It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
//	Space complexity should be O(n).
//	Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
	
	 public int[] countBits(int num) {
		
		int[] r = new int[num+1];
		//r[i] = r[i&(i-1)] + 1
		r[0] = 0;
		for(int i=1;i<num+1;i++) {
			r[i] = r[i&(i-1)] + 1;
	 	}
		return r;
	 }

	 public static void main(String[] args) {
		 P338CountingBits q = new P338CountingBits();
		 int[] r = q.countBits(1);
		 for (int rr : r){
			 System.out.println(rr);
		 }
	 }
}
