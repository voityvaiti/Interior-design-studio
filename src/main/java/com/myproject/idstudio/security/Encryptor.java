package com.myproject.idstudio.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	public static String encrypt(String strToEncrypt) throws NoSuchAlgorithmException {
		byte[] bytesArrOfEncryptedStr = MessageDigest.getInstance("MD5").digest(strToEncrypt.getBytes());
		StringBuilder encryptedStringBuilder = new StringBuilder();
		for(byte b: bytesArrOfEncryptedStr) {
			encryptedStringBuilder.append(String.format("%02X", b));
		}
		return encryptedStringBuilder.toString();
	}
}
