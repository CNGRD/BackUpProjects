package collectionPrograms;
import java.util.*;
public class Occurance {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.nextLine();
		LinkedHashSet<Character> set=new LinkedHashSet<Character>();
		
		for(int i=0;i<str.length();i++)
		{
			set.add(str.charAt(i));
		}
		for(Character ch:set)
		{
			int count=0;
			for(int i=0;i<str.length();i++)
			{
				if(ch==str.charAt(i))
				{
					count++;
				}
			}
			//System.out.println(ch+" "+count);
			if(count>1)
			{
				System.out.println("Repeated character is "+ch);
			}
		}
		

	}

}
