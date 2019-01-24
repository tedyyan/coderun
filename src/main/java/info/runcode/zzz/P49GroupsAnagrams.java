package info.runcode.zzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class P49GroupsAnagrams {
//	Given an array of strings, group anagrams together.
//
//	Example:
//
//	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//	Output:
//	[
//	  ["ate","eat","tea"],
//	  ["nat","tan"],
//	  ["bat"]
//	]
//	Note:
//
//	All inputs will be in lowercase.
//	The order of your output does not matter.
	
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,List<String>> rr = new HashMap<String,List<String>>();
		if ((strs == null)||(strs.length==0)) {
			return new ArrayList<List<String>>();
		}

		for(String el:strs) {
			char[] a = el.toCharArray();
			Arrays.sort(a);
			String b = String.valueOf(a, 0, a.length);
			List<String> rel = rr.get(b);
			if (rel!=null) {
				rel.add(el);
			}else {
				ArrayList<String> relnew = new ArrayList<String>();
				relnew.add(el);
				rr.put(b, relnew);
			}
		}
		Collection<List<String>> tmp = rr.values();
		return new ArrayList<List<String>>(tmp);        
    }
	
	
	public static void main(String[] args) {
		P49GroupsAnagrams p = new P49GroupsAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat",""};
		List<List<String>> result = p.groupAnagrams(strs );
		for (List<String> el : result) {
			for(String elel : el) {
				System.out.print(elel);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
}
