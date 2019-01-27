package info.runcode.zzz;

import java.util.ArrayList;
import java.util.List;

public class P93RestoreIPAddress {
//	Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//	Example:
//
//	Input: "25525511135"
//	Output: ["255.255.11.135", "255.255.111.35"]	
	private boolean dfs(int start,String in, List<String> tmprr, int needpoint, List<String> rr){
		if(needpoint==1) {
			if((in.length()-start > 3)) {
				return false;
			}
			String el = in.substring(start);
			Integer v = Integer.valueOf(el);
			if (v>255) {
				return false;
			}else {
				
				//TODO tmprr add to tmp
				String result = "";
				for(String el2:tmprr) {
					result = el2+".";
				}
				result = result+el;
				rr.add(result);
			}
			return true;
		}
		
		for(int i=0;i<needpoint;i++) {
			for(int j=start+1;j<in.length()+1;j++) {
				if (j-start>3) {
					break;
				}
				String one = in.substring(start, j);				
				Integer v = Integer.valueOf(one);
				if (v>255) {
					continue;
				}
				tmprr.add(one);
				dfs(j,in,tmprr,needpoint-1,rr);
				tmprr.remove(one);
				
			}
		}

		return true;
	}

	public List<String> restoreIpAddresses(String s) {
		
		ArrayList<String> rr = new ArrayList<String>();
		dfs(0, s, new ArrayList<String>(), 3, rr);
		
		return rr;
        
    }
	
	public static void main(String[] args) {
		P93RestoreIPAddress p = new P93RestoreIPAddress();
		List<String> result = p.restoreIpAddresses( "25525511135");
		for (String el : result) {
			System.out.println(el);
		}
	}
}
