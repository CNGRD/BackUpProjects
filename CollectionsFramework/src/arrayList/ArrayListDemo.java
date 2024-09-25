package arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) 
	{
		//Declare ArrayList
		//ArrayList al=new ArrayList();
		//ArrayList<Integer> al=new ArrayList<Integer>();
		//ArrayList<String> al=new ArrayList<String>();
		//List al=new ArrayList();
		
		ArrayList<Comparable> al=new ArrayList<Comparable>();
		//add new elements to the arrayList
		al.add(100);
		al.add("welcome");
		al.add(15.5);
		al.add('A');
		al.add(true);
		System.out.println(al);//[100, welcome, 15.5, A, true]
		//size
		int size=al.size();
		System.out.println(size);
		
		//remove
		al.remove(1);//here 1 is index
		al.remove("welcome");//we can pass element as well
		System.out.println(al);

	}

}
