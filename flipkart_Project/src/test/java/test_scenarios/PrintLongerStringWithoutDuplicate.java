package test_scenarios;

public class PrintLongerStringWithoutDuplicate {

	public static void main(String[] args) 
	{
		
		String str="dogcatdogtiger";
		
		String longstring="";
		String temp="";
		
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<=str.length();j++)
			{
				temp=longstring.substring(i,j);
			}
			
		}
		System.out.println(temp);
	}

}
