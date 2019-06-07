package edu.mum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pu {
	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> usedList = new ArrayList<Integer>();
		Integer[] eles = {1,2,3,4};
		combinationSum(result, usedList, eles,0,6);
		for(List<Integer> e:result) {
			System.out.println(e);
		}
		
	}
	static void permutation(List<List<Integer>> result, List<Integer> usedList, Integer[] elements){
		if(usedList.size() == elements.length) {
			Integer[] a = new Integer[elements.length];
			a = usedList.toArray(a);
			List<Integer> one = Arrays.asList(a);			
			result.add(one );
		}
		for(Integer ele:elements) {
			if(!usedList.contains(ele)) {
				usedList.add(ele);
				permutation(result,usedList,elements);
				usedList.remove(usedList.size()-1);
			}
		}
	
	}
	
	static void combination(List<List<Integer>> result, List<Integer> usedList, Integer[] elements, int num, int cnt) {
		if(usedList.size() == cnt) {
						
			result.add(new ArrayList<Integer>(usedList) );
		}
		for(int i=num;i<elements.length;i++) {
			if(!usedList.contains(elements[i])) {
				usedList.add(elements[i]);
				combination(result,usedList,elements,i+1,cnt);
				usedList.remove(usedList.size()-1);
			}
		}
	}
	
	static void combinationSum(List<List<Integer>> result, List<Integer> usedList, Integer[] elements, int num, int target) {
		if(target<0) {
			return;
		}
		if(target==0) {
			result.add(new ArrayList<Integer>(usedList) );
			return;
		}
		for(int i=num;i<elements.length;i++) {
			if(!usedList.contains(elements[i])) {
				usedList.add(elements[i]);
				combinationSum(result,usedList,elements,i,target-elements[i]);
				usedList.remove(usedList.size()-1);
			}
		}
	}
}