package mockingStub;

import org.mockito.Mockito;

class PancardValidation
{
	public String isValid(String panCard)
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true)
		{
			return "is valid pan";
		}
		else
		{
			return "is Invalid pan";
		}
	}
	
	public static PancardValidation getMockitoObject()
	{
	  PancardValidation mocObj= Mockito.mock(PancardValidation.class);
	  							Mockito.when(mocObj.isValid("ABCDE1234A")).thenReturn("Valid PAN card");
	  							Mockito.when(mocObj.isValid("ABCDE1234B")).thenReturn("Valid PAN card");
	  							Mockito.when(mocObj.isValid("ABCDE1234c")).thenReturn("InValid PAN card");
	  return mocObj;
	  
	}
}

public class MockingTest {

	public static void main(String[] args) 
	{
		PancardValidation obj=PancardValidation.getMockitoObject();
		System.out.println(obj.isValid("ABCDE1234A"));
	}

}
