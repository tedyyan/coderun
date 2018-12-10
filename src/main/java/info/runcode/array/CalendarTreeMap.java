package info.runcode.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class CalendarTreeMap {

	// 729. My Calendar I
	// Medium
	// 288
	// 23
	//
	//
	// Implement a MyCalendar class to store your events. A new event can be added
	// if adding the event will not cause a double booking.
	//
	// Your class will have the method, book(int start, int end). Formally, this
	// represents a booking on the half open interval System.out.println(p.book(start, end),
	// the range of real numbers x such that start <= x < end.
	//
	// A double booking happens when two events have some non-empty intersection
	// (ie., there is some time that is common to both events.)
	//
	// For each call to the method MyCalendar.book, return true if the event can be
	// added to the calendar successfully
	// without causing a double booking. Otherwise, return false and do not add the
	// event to the calendar.
	//
	// Your class will be called like this: MyCalendar cal = new MyCalendar();
	// MyCalendar.book(start, end)
	// Example 1:
	// MyCalendar();
	// MyCalendar.book(10, 20); // returns true
	// MyCalendar.book(15, 25); // returns false
	// MyCalendar.book(20, 30); // returns true
	// Explanation:
	// The first event can be booked. The second can't because time 15 is already
	// booked by another event.
	// The third event can be booked, as the first event takes every time less than
	// 20, but not including 20.

	// Note:
	//
	// The number of calls to MyCalendar.book per test case will be at most 1000.
	// In calls to MyCalendar.book(start, end), start and end are integers in the
	// range System.out.println(p.book(0, 10^9].

	TreeMap<Integer, Integer> a = new TreeMap<Integer, Integer>();

	public CalendarTreeMap() {

	}

	public boolean book(int s, int e) {

		if (s >= e) {
			return false;
		}
		e = e - 1;
		if (a.size() == 0) {
			a.put(s, e);
			return true;
		}
		if (e < a.firstKey().intValue()) {
			a.put(s, e);
			return true;
		}
		if (s > a.lastEntry().getValue()) {
			a.put(s, e);
			return true;
		}
		Entry<Integer, Integer> biggerthankey = a.higherEntry(s-1);
		Entry<Integer, Integer> lessthankey = a.lowerEntry(s);
		if ((biggerthankey==null)||(lessthankey == null)) {
			return false;
		}
		
		if ((e < biggerthankey.getKey().intValue()) && (e > lessthankey.getValue().intValue()) && (s<biggerthankey.getKey().intValue()) && (s > lessthankey.getValue().intValue()) ) {
			a.put(s, e);
			System.out.println(a.toString());
			return true;
		} else {
			return false;
		}
	}

	// MyCalendar();
	// MyCalendar.book(10, 20); // returns true
	// MyCalendar.book(15, 25); // returns false
	// MyCalendar.book(20, 30); // returns true

	public static void main(String[] args) {
		CalendarTreeMap p = new CalendarTreeMap();
//		System.out.println(p.book(37, 50));
//		System.out.println(p.book(33, 50));//false
//		System.out.println(p.book(4, 17));
//
//		System.out.println(p.book(35, 48));//false
//		System.out.println(p.book(8, 5));//false
		
		System.out.println(p.book(23,32));System.out.println(p.book(42,50));System.out.println(p.book(6,14));System.out.println(p.book(0,7));System.out.println(p.book(21,30));System.out.println(p.book(26,31));System.out.println(p.book(46,50));System.out.println(p.book(28,36));System.out.println(p.book(0,6));System.out.println(p.book(27,36));System.out.println(p.book(6,11));System.out.println(p.book(20,25));System.out.println(p.book(32,37));System.out.println(p.book(14,20));System.out.println(p.book(7,16));System.out.println(p.book(13,22));
		//System.out.println(p.book(40, 120));
		//System.out.println(p.book(102, 110));
		//System.out.println(p.book(39, 40));
	}

}
