package info.runcode.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class CalenderLinkedList {

//		729. My Calendar I
//		Medium
//		288
//		23
	//
	//
//		Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
	//
//		Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), 
		//the range of real numbers x such that start <= x < end.
	//
//		A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
	//
//		For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully 
		//without causing a double booking. Otherwise, return false and do not add the event to the calendar.
	//
//		Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
//		Example 1:
//		MyCalendar();
//		MyCalendar.book(10, 20); // returns true
//		MyCalendar.book(15, 25); // returns false
//		MyCalendar.book(20, 30); // returns true
//		Explanation: 
//		The first event can be booked.  The second can't because time 15 is already booked by another event.
//		The third event can be booked, as the first event takes every time less than 20, but not including 20.
		
//		Note:
	//
//			The number of calls to MyCalendar.book per test case will be at most 1000.
//			In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

		
		LinkedList<Integer> a = new LinkedList<Integer>();
		
		public CalenderLinkedList() {
	       
	    }
	    

			 public boolean book(int s, int e) {

			        if (s>=e) {
			    		return false;
			    	}
			    	e = e-1;
			    	if (a.size() == 0) {
			    		a.addFirst(s);
			    		a.addLast(e);
			    		return true;
			    	}
			    	if (e<a.getFirst()) {
						//add to left
			    		a.addFirst(e);
			    		a.addFirst(s);
						return true;
			    	}
					if (s>a.getLast()) {
						a.addLast(s);
						a.addLast(e);
						return true;
					}
					int p1 = -1;
			    	Iterator<Integer> b = a.iterator();
			    	int index = 0;
					while (b.hasNext()) {
						int l = b.next();
						int r = b.next();
						if (p1==-1) {
							p1 = r; 
						}
						if ((s == l)||(s==r)||(e == l)||(e==r)) {
							return false;
						}
						if ((s<r)&&(s>l)) {
							return false;
						}			
						if ((e>l)&&(e<r)) {
							return false;
						}			
						if ((s<l)&&(e>r)) {
							return false;
						}
						if ((s>p1)&&(e<l)) {
							a.add(index, s);
							a.add(index+1, e);
					    	System.out.println(Arrays.toString(a.toArray()));
							return true;
						}
						p1 = r;

						index =index+2;
					}
					
			        return true;
			    }
			    
//				MyCalendar();
//				MyCalendar.book(10, 20); // returns true
//				MyCalendar.book(15, 25); // returns false
//				MyCalendar.book(20, 30); // returns true
			    
			    public static void main(String[] args) {
			    	CalenderLinkedList p = new CalenderLinkedList();
			    	System.out.println(p.book(10, 20));
			    	System.out.println(p.book(15, 25));
			    	System.out.println(p.book(20, 30));

			    	System.out.println(p.book(21, 22));
			    	System.out.println(p.book(131, 132));
			    	System.out.println(p.book(40, 120));
			    	System.out.println(p.book(102, 110));
			    	System.out.println(p.book(39, 40));
			    }
	
}
