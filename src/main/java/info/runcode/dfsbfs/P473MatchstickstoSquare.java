package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P473MatchstickstoSquare {
//	473. Matchsticks to Square
//	Medium
//
//	289
//
//	37
//
//	Favorite
//
//	Share
//	Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
//	Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
//
//	Example 1:
//	Input: [1,1,2,2,2]
//	Output: true
//
//	Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
//	Example 2:
//	Input: [3,3,3,3,4]
//	Output: false
//
//	Explanation: You cannot find a way to form a square with all the matchsticks.
//	Note:
//	The length sum of the given matchsticks is in the range of 0 to 10^9.
//	The length of the given matchstick array will not exceed 15.
	
	 public boolean makesquare(int[] nums) {
	        if (nums == null || nums.length < 4) {
	            return false;
	        }

	        int tmp = 0;
	        for (int i : nums) {
	            tmp += i;
	        }

	        if (tmp % 4 != 0) {
	            return false;
	        }

	        Arrays.sort(nums);
	        ArrayList <Integer> a = new ArrayList<Integer>();
	        for(int i=nums.length-1;i>-1;i--) a.add(nums[i]);
	     
	        for (int i=0;i<4;i++){
	            boolean onestep = robot(a, tmp / 4,0);
	            //System.out.println("done:"+i+onestep);
	            if(onestep!=true)
	                return false;
	        }
	        return true;
	    }

	    private boolean robot(List<Integer> lnums, int sum,int k) {
	        //System.out.println(lnums+" s:"+sum+" k:"+k);
	        if(k>lnums.size()-1)
	            return false;
	        int first = lnums.get(k);
	        if(sum-first == 0){
	            lnums.remove(k);
	            return true;
	        }
	        
	        if(sum-first < 0)
	            return false;
	        lnums.remove(k);
	        boolean tmp = robot(lnums,sum-first,k);
	        if (k>=lnums.size()-1 && tmp == false){            
	            lnums.add(k,first);
	            return false;
	        }
	        
	        
	        int i=1;
	        while(tmp == false){            
	            if(k+i>lnums.size()-1) return false;            
	            tmp = robot(lnums,sum-first,k+i);
	            
	            if(tmp==false && k+i==lnums.size()-1){     
	                lnums.add(k,first);
	                return false;
	            }
	            
	            i++;
	        }
	        return true;
	    }
	    
	    public static void main(String args[]) {
	    	P473MatchstickstoSquare p = new P473MatchstickstoSquare();
	    	int[] in = new int[] {12,13,1,15,11,17,16,3,15,11,13,4,2,16,15};
	    	int[] in2 = new int[] {16,8,8,8,5,1,16,3,11,1,11,12,20,6,6};
	    	int[] in3 = new int[] {7,1,13,6,19,18,12,3,15,4,20,11,2,15,14};
	    	int[] in4 = new int[] {3,3,3,3,4};
	    	int[] in5 = new int[] {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4};
	    	System.out.println("-------------------------------------------------"+p.makesquare(in));

	    	System.out.println("-------------------------------------------------"+p.makesquare(in2));
	    	System.out.println("-------------------------------------------------"+p.makesquare(in3));
	    	System.out.println("-------------------------------------------------"+p.makesquare(in4));
	    	System.out.println("-------------------------------------------------"+p.makesquare(in5));
	    }
}
