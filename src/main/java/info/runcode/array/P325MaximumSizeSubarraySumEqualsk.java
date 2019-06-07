package info.runcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P325MaximumSizeSubarraySumEqualsk {
	public int maxSubArrayLenMine(int[] nums, int k) {
        int result = -1;
        int cnt = nums.length;
        if (cnt==0) return 0;
        List<List<Integer>> vals= new ArrayList<List<Integer>>();
        
        for(int i=0;i<cnt;i++){
            ArrayList tmp = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                tmp.add(0);
            }
            vals.add(tmp);
        }
        for(int i=0;i<cnt;i++){
            for(int j=0;j<=i;j++){
                
                if(i-j < result){
                    //System.out.println(" j: "+j+" i: "+i+" vals[j][i]: "+vals[j][i] );
                    //break;
                }
                if (i==j)
                {
                    List<Integer> tmp = vals.get(i);
                    tmp.set(j,nums[i]);
                }else{
                    List<Integer> tmp = vals.get(i);
                    tmp.set(j,vals.get(i-1).get(j) + nums[i]);
                    
                }
                //System.out.println(" j: "+j+" i: "+i+" vals[j][i]: "+vals.get(i).get(j) );
                if(vals.get(i).get(j)==k){
                    if(i-j > result) 
                        result = i-j;
                }
            }
        }
        return result + 1;
    }
	
	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int sum = 0,i=0,max=0;
		for(int num_:nums) {
			sum = sum + nums[i];
			if(sum==k) max = i+1;
			if(hm.containsKey(sum-k)) {
				max = Math.max(max, i-hm.get(sum-k));
			}
			if(!hm.containsKey(sum)) {
				hm.put(sum, i);
			}
			i++;
		}
		return max;
	}
}
