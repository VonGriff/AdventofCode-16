import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.Math;
import java.lang.StringBuilder;

// TODO

// Part01 goal: with a given input and an increasing index starting at 0, hash it
// with MD5 until a hexadecimal representation of that hash has 5 leading zeroes.
// Find 8 such hashes and add together the 6th character in the hex value.
public class Part01 {

	private String input;
	private String pwd;
	private static MessageDigest md;
	
	public Part01(MessageDigest md, String input) {
		this.md = md;
		this.input = input;
		pwd = "";
	}

	// Executes everything for Part01 and returns the password needed.
	public String run() {
		int index = 0;
		int pwdIndex = 0;

		while (pwd.length() < 8) {
			String hash = hash(input + index);
			if (hash.startsWith("00000")) {
				// pwd[pwdIndex] = hash.charAt(5);
				pwd += hash.charAt(5);
				pwdIndex++;
			}
			// if (index % 1000000 == 0) {
			// 	System.out.println("MILJON!");
			// }
			index++;
		}
		return pwd;
	}

	// Hashes a given String and returns a String hexidecimal
	// representation of the hash
	private static String hash(String s) {
		byte[] b = s.getBytes();
		b = md.digest(b);
		// String t = "";
		StringBuilder sb = new StringBuilder();

		for (Byte by: b) {
			// System.out.println(by);
			if (by < 0) {
				sb.append(hex(0xff + by + 1));
			}
			else if (by < 16) { // Adds a zero due to 0x0 representation rather than 0x00
				sb.append("0" + hex(by));
			}
			else {
				sb.append(hex(by));
			}
		}
		md.reset();
		return sb.toString();
	}

	// Checks if a hexidecimal value has 5 leading zeroes
	// private boolean validHash(String hash) {
	// 	// for (int i = 0; i < 5; i++) {
	// 	// 	if (hash.charAt(i) != '0') {
	// 	// 		return false;
	// 	// 	}
	// 	// }
	// 	return hash.startsWith("00000");
	// 	// System.out.println("Valid!");
	// 	// System.out.println(hash);
	// 	// return true;
	// }

	// Returns an int as a String of it's hexadecimal form
	private static String hex(int n) {
    	return Integer.toHexString(n);
	}
}