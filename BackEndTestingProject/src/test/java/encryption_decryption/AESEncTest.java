package encryption_decryption;

import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;
/*
 * private key:Ac03tEam@j!tu_#1
 */

public class AESEncTest 
{
	@Test
	public void sampleTest() throws NoSuchPaddingException, Exception
	{
		String privateKey="Ac03tEam@j!tu_#1";
		String data="Nithin";
		
		EncryptAndDecryptUtility ed=new EncryptAndDecryptUtility();
		String en=ed.encrypt(data, privateKey);
		System.out.println(en);
		String dec=ed.decrypt("4ZG68Kg0PoZMIlTfx7hVlw==", privateKey);
		System.out.println(dec);
	}

}
