package arrayList;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string Data");
		String str=sc.nextLine();
		
		String s="";
		
		char ch;
		for (int i=0; i<str.length(); i++)
	      {
	        ch= str.charAt(i); //extracts each character
			s= ch+s; //adds each character in front of the existing string
	      }
		System.out.println(s);

	}
//	public static void main (String[] args) {
//	      
//        String str= "Geeks", nstr="";
//        char ch;
//      
//      System.out.print("Original word: ");
//      System.out.println("Geeks"); //Example word
//      
//      for (int i=0; i<str.length(); i++)
//      {
//        ch= str.charAt(i); //extracts each character
//        nstr= ch+nstr; //adds each character in front of the existing string
//      }
//      System.out.println("Reversed word: "+ nstr);
//    }

}
