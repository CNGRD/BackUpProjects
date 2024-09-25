package com.ninza.hrm.api.genericutility;
/**
 * 
 * @author Nithin
 * 
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionAndDecryptionUtils {

    private static final String ALGORITHM = "AES";

    // Generate a new AES SecretKey
    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }

    // Convert a SecretKey to a Base64 encoded string
    public static String encodeKey(SecretKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    // Convert a Base64 encoded string to a SecretKey
    public static SecretKey decodeKey(String keyStr) {
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
    }

    // Encrypt a string using the given SecretKey
    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    // Decrypt a string using the given SecretKey
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
        
    }

 }    
		/*
		 * public static void main(String[] args) { try { // Generate a key SecretKey
		 * secretKey = generateKey(128); // 128-bit AES key
		 * 
		 * // Convert key to string and back String encodedKey = encodeKey(secretKey);
		 * SecretKey decodedKey = decodeKey(encodedKey);
		 * 
		 * // Encrypt and decrypt a message String originalMessage = "Hello, World!";
		 * String encryptedMessage = encrypt(originalMessage, decodedKey); String
		 * decryptedMessage = decrypt(encryptedMessage, decodedKey);
		 * 
		 * // Display results System.out.println("Original Message: " +
		 * originalMessage); System.out.println("Encrypted Message: " +
		 * encryptedMessage); System.out.println("Decrypted Message: " +
		 * decryptedMessage); } catch (Exception e) { e.printStackTrace(); } } }
		 */
        
     