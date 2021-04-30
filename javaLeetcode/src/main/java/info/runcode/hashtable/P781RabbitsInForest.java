package info.runcode.hashtable;

import java.util.HashMap;

public class P781RabbitsInForest {
//	781. Rabbits in Forest
//	Medium
//	112
//	152
//
//
//	In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you 
//	how many other rabbits have the same color as them. Those answers are placed in an array.
//
//	Return the minimum number of rabbits that could be in the forest.
//
//	Examples:
//	Input: answers = [1, 1, 2]
//	Output: 5
//	Explanation:
//	The two rabbits that answered "1" could both be the same color, say red.
//	The rabbit than answered "2" can't be red or the answers would be inconsistent.
//	Say the rabbit that answered "2" was blue.
//	Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
//	The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 
//	2 that didn't.
//
//	Input: answers = [10, 10, 10]
//	Output: 11
//
//	Input: answers = []
//	Output: 0
//	Note:
//
//	answers will have length at most 1000.
//	Each answers[i] will be an integer in the range [0, 999].
	
	
	public int numRabbits(int[] a) {
		int t = 0;
		if (a==null) {
			return 0;
		}
		HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
		for (int i=0;i<a.length;i++) {
			int k=a[i]+1;
			if (k==1) {
				t++;
			}else {	
				Integer v = hs.get(k);
				if (v!=null) {
					int z = v.intValue() -1;
					if (z == 0) {
						hs.remove(k);
					}else {
						hs.put(k, z);
					}
				}else {
					hs.put(k, a[i]);
					t = t + a[i] + 1;
				}
			}
		}
		return t;
        
    }
	 public static void main(String[] args) {
		 P781RabbitsInForest p = new P781RabbitsInForest();
		 int[] input = new int[] {0,0,2,2,1,2}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2
		
		 System.out.println((p.numRabbits(input)));
		 
	 }
}
