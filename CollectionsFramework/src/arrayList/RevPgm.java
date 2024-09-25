package arrayList;

import java.util.Scanner;

public class RevPgm {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String :");
		String str=sc.nextLine();
		
		String s="";
		char ch;
		 for(int i=0;i<str.length();i++)
		 {
			 ch=str.charAt(i);
			 s=ch+s;
		 }
		 System.out.println(s);
	}

}
