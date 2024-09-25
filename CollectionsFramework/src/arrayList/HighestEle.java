package arrayList;

import java.util.Scanner;

public class HighestEle {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int[] a1=new int[5];
		System.out.println("Enter the Elements");
		for(int i=0;i<a1.length;i++)
		{
			a1[i]=sc.nextInt();
			System.out.println("Entered element @ index :"+i+" is :"+a1[i]);
		}
		
		int highest=a1[0];
		for(int j=0;j<a1.length;j++)
		{
			if(highest<a1[j])
			{
				highest=a1[j];
			}
		}
		System.out.println("This is the highest element:"+highest);
		System.out.println("Hi Nithin How are you");
	}

}
