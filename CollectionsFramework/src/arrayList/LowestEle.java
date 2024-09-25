package arrayList;

public class LowestEle {

	public static void main(String[] args) 
	{
		int[] arr= {5,2,6,8,78,99};
		
		int lowest=arr[0];
		
		for(int i=0;i<arr.length;i++)
		{
			if(lowest>arr[i])
			{
				lowest=arr[i];
			}
		}
		System.out.println(lowest);

	}

}
