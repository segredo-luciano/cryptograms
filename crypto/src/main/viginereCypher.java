package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class viginereCypher {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(
									new InputStreamReader(System.in));
		
		String msgIn = "";
		String msgOut = "";
		String key = "";
		String option = "";
	
		System.out.print("Digite o texto: ");
		msgIn = reader.readLine();
		System.out.println("Digite a chave: ");
		key = reader.readLine();
		
		System.out.print("Digite <E> para encriptar ou " +
							"<D> para decriptar: ");
		option = reader.readLine();
		
		if (option.equalsIgnoreCase("E")) {
			msgOut = encrypt(msgIn, key);
		} else {
			msgOut = decrypt(msgIn, key);
		}
		
		System.out.print(msgOut);
	
	}
	
	private static String encrypt(String text, String key) {
		String answer = "";
		
		for (int i=0; i < text.length(); i++) {
			int textLetter = text.charAt(i);
			int keyLetter = key.charAt(i % key.length());
			int XORLetter = (textLetter ^ keyLetter);
			String caracter = Integer.toHexString(XORLetter);
			
			answer += (caracter.length() == 2 ? "" : "0") + caracter;
		}
		
		return answer;
	}
	
//	Crypto always have double size from original text
	private static String decrypt(String text, String key) {
		String msg = "";
		
		for (int i=0; i<text.length() - 1; i+=2) {
			String textLetter = text.substring(i, i + 2);
			int keyLetter = key.charAt(i/2 % key.length());
			int XORLetter = (Integer.parseInt(textLetter, 16) ^ keyLetter);
			
			msg += (char) + XORLetter;
		}
		
		return msg;
		
	}
}
