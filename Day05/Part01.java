import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.Math;

public class Part01 {

	private String input;
	private static MessageDigest md;
	private String pwd;
	
	public Part01(MessageDigest md, String input) {
		this.md = md;
		this.input = input;
		pwd = "";
	}

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
			if (index % 1000000 == 0) {
				System.out.println("MILJON!");
			}
			index++;
		}
		return pwd;
	}

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

	private boolean validHash(String hash) {
		for (int i = 0; i < 5; i++) {
			if (hash.charAt(i) != '0') {
				return false;
			}
		}
		System.out.println("Valid!");
		System.out.println(hash);
		return true;
	}

	private static String hex(int n) {
    	return Integer.toHexString(n);
	}
}