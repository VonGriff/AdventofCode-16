import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.Math;

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

		while (index < Integer.MAX_VALUE) {
			String hash = hash(input + index);
			if (validHash(hash)) {
				// pwd[pwdIndex] = hash.charAt(5);
				pwd = pwd + hash.charAt(5);
				pwdIndex++;
			}
			if (pwd.length() == 8) {
				break;
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
		String t = "";

		for (Byte by: b) {
			// System.out.println(by);
			if (by < 0) {
				t = t + hex(0xff + by + 1);
			}
			else if (by < 16) {
				t = t + "0" + hex(by);
			}
			else {
				t = t + hex(by);
			}
		}
		// md5.reset();
		return t;
	}

	// Checks if a hexidecimal value has 5 leading zeroes
	private boolean validHash(String hash) {
		for (int i = 0; i < 5; i++) {
			if (hash.charAt(i) != '0') {
				return false;
			}
		}
		// System.out.println("Valid!");
		// System.out.println(hash);
		return true;
	}

	// Returns an int as a String of it's hexadecimal form
	private static String hex(int n) {
    	return Integer.toHexString(n);
	}
}