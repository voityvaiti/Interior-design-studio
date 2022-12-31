package com.webapp.business_card.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	public static String encrypt(String str) throws NoSuchAlgorithmException {
		byte[] bytes = MessageDigest.getInstance("MD5").digest(str.getBytes());
		StringBuilder encryptedStringBuilder = new StringBuilder();
		for(byte b: bytes) {
			encryptedStringBuilder.append(String.format("%02X", b));
		}
		return encryptedStringBuilder.toString();
	}
}
