package info.runcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class P187RepeatedDNASequences {
//	187. Repeated DNA Sequences
//	Medium
//
//	370
//
//	144
//
//	Favorite
//
//	Share
//	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
//	When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//	Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//	Example:
//
//	Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//
//	Output: ["AAAAACCCCC", "CCCCCAAAAA"]
	
	
	

	 public static void main(String[] args) {
		 P187RepeatedDNASequences p = new P187RepeatedDNASequences();
		 List<String> r = p.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");  //
		 for(String t : r) {
			 System.out.println(t);			 
		 }
	 }
	public List<String> findRepeatedDnaSequences(String s) {
		if ((s==null)||(s.length()<=10)){
			return new ArrayList<String>();
		}
		Map<String,Integer> r = new HashMap<String,Integer>();
        String tmp = "";
        Integer value = 0;
		for(int i=0;i+10<=s.length();i++) {
			tmp = s.substring(i, i+10);
			value = r.get(tmp);
			if (value == null) {
				r.put(tmp, 1);
			}else {
                if(value == 1)
				    r.put(tmp, value.intValue() + 1);
			}
		}
		
		List<String> result = new ArrayList<String>();
		Iterator<String> it = r.keySet().iterator();
        String itvalue;
		while (it.hasNext()) {
			itvalue= it.next();
			if (r.get(itvalue).intValue()>1) {				
				result.add(itvalue);
			}
		}
		return result;
	}
	
	//--------------------------------------------------------------------------------
	// this answer is totally wrong, I didn't understand the question. The following code is what?
	
	class Cnt{
		public Cnt(int i, int cnt) {
			this.repeat =i;
			this.length =cnt;
		}
		int repeat;
		int length;
	}
	
	public List<String> findRepeatedDnaSequences_TotalMisunderstand(String s) {
		if ((s==null)||(s.length()==0)){
			return new ArrayList<String>();
		}
		Map<String,Cnt> r = new HashMap<String,Cnt>();
		Map<String,Cnt> rr = new HashMap<String,Cnt>();
		char c = s.charAt(0);
		int cnt = 0;
		Iterator<String> it = null;
		for(int i=1;i<s.length();i++) {
			cnt++;
			if (s.charAt(i)!=c) {
				String tmp = c + String.valueOf(cnt);
				Cnt as = r.get(tmp);
				if (as!=null) {
					as.repeat = as.repeat + 1;
				}else {
					rr.clear();
					rr.put(tmp, new Cnt(1,cnt));
					it = r.keySet().iterator();
					while(it.hasNext()) {
						String itvalue = it.next();
						rr.put(itvalue+tmp, new Cnt(1,r.get(itvalue).length + cnt));
					}
					it = rr.keySet().iterator();
					while(it.hasNext()) {
						String itvalue = it.next();
						r.put(itvalue, rr.get(itvalue ));
					}
				}
				cnt = 0;
				c = s.charAt(i);
			}
		}
		List<String> result = new ArrayList<String>();
		it = r.keySet().iterator();
		while (it.hasNext()) {
			String itvalue = it.next();
			if ((r.get(itvalue).length==10) && (r.get(itvalue).repeat>1)) {				
				result.add(extendSub(itvalue));
			}
		}
		return result;        
    }
	
	int fetchLength(String input) {
		return Integer.valueOf(input.substring(1));
	}
	
	String extendSub(String input) {
		String t = input.substring(0, 1);
		int len = fetchLength(input);
		StringBuffer r = new StringBuffer();
		while (len>0) {
			len--;
			r.append(t);
		}
		return t.toString();
	}
	
}

