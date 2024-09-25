package arrayList;
import java.util.*;
public class CountChar {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String str=sc.nextLine();
		
		
		LinkedHashSet< Character> set=new LinkedHashSet<Character>();

			for(int i=0;i<str.length();i++)
			{
				set.add(str.charAt(i));
			}
			int count=0;
			for(Character ch:set)
			{
				count++;
			}
			System.out.println(count);
		
		
	}

}
