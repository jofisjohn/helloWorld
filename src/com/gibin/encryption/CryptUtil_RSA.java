package com.gibin.encryption;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class CryptUtil_RSA {
	
	private static KeyPairGenerator keyPairGenerator;
	private static KeyPair keyPair;
	private static PublicKey publicKey;
	private static PrivateKey privateKey;
	
	private static int KEY_SIZE = 1024;
	
	private static Cipher cipher;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Starting Crypto Tool");
		generateKeypair();
		
		writeToFile("keypair/public", publicKey.getEncoded());
		writeToFile("keypair/private", privateKey.getEncoded());
		
		cipher = Cipher.getInstance("RSA");
		
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encipher = cipher.doFinal("{Indocosmo systems private limited} ".getBytes());
		System.out.println("ENCRY "+new String(encipher));
		
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decipher = cipher.doFinal(encipher);
		System.out.println("DCRY "+new String(decipher));
					
	}
	
	public static void generateKeypair() throws Exception {
		try {
			
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(KEY_SIZE);
			createKeys();
		}
		catch(Exception e) {
			throw new Exception(""+e.getMessage());
			
		}
		
	}
	public static void createKeys() {
		keyPair = keyPairGenerator.generateKeyPair();
		publicKey = keyPair.getPublic();
		privateKey = keyPair.getPrivate();
		System.out.println("PUBLIC :"+publicKey.toString()+"\n\nPRIVATE :"+privateKey.toString());
	}

	public static void writeToFile(String filepath,byte[] bytes) throws Exception
	{
		File file = new File(filepath);
		file.getParentFile().mkdirs();
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(bytes);
		fileOutputStream.flush();
		fileOutputStream.close();
	}
	
	
	
	
	
	
	
}
