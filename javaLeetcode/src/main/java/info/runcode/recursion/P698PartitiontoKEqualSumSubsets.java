package info.runcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class P698PartitiontoKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		int total = 0;
		for(int num:nums) {
			total += num;
			arraylist.add(num);
		}
		if (total%k!=0) return false;
		
		
		
		boolean[] visited = new boolean[nums.length];
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
		return rr(arraylist,total/k,total/k,0,visited ,k);
	}

	private boolean rr(ArrayList<Integer> arraylist, int remain, int total,int pos,boolean[] visited,int cycle) {
		if(cycle==0) return true;
		for(int i=pos;i<arraylist.size();i++) {
            if(!visited[i]) {
            	visited[i] = true;
            	int r = remain-arraylist.get(i);
            	if(r>0) {
            		return rr(arraylist,r,total,pos+1,visited,cycle);
            	}else if(r==0){
            		return rr(arraylist,total,total,0,visited,cycle-1);
            	}else {
                	visited[i] = false;
                	continue;
            	}
            }
		}
		return false;
		
	}
	
	public boolean search1(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search1(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search1(new int[k], row, nums, target);
    }
}
