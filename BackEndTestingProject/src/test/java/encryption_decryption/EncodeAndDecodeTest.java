package encryption_decryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecodeTest 
{
	@Test
	public void sampleTest()
	{
		//String str=new String(Base64.getEncoder().encode("ABCD".getBytes()));
		//System.out.println(str);
		String str1=new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println(str1);
		
	}

}
