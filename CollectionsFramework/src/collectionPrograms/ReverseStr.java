package collectionPrograms;
import java.util.*;
public class ReverseStr {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String str=sc.nextLine();
		String strRev="";
		char ch;
		for(int i=0;i<str.length();i++)
		{
			ch=str.charAt(i);
			strRev=ch+strRev;
		}
		System.out.println(strRev);
	}

}
