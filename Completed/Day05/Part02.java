import java.security.MessageDigest;

// TODO

// Part02 goal: Much like part01, except the 6th charachter in the hex value is the index
// in the password and the 7th character is the actual value
public class Part02 {
	
	private static MessageDigest md;
	private String input;
	private String[] pwd;

	public Part02(MessageDigest md, String input) {
		this.md = md;
		this.input = input;
		pwd = new String[8];
	}

	// finds the values for the password and returns it
	public String run() {
		int index = 0;
		int pwdIndex = 0;
		String hash;

		while (index < Integer.MAX_VALUE) {
			hash = hash(input + index);
			if (validHash(hash)) {
				// pwd[pwdIndex] = hash.charAt(5);
				String[] tempHash = hash.split("");
				int tempIndex = Integer.parseInt(tempHash[5]);
				if (pwd[tempIndex] == null) {
					pwd[tempIndex] = tempHash[6];
					pwdIndex++;
				}
				else {
					System.out.println("DOUBLE!");
				}
			}
			if (pwdIndex == 8) {
				break;
			}
			if (index % 1000000 == 0) {
				System.out.println("MILJON!");
			}
			index++;
		}
		String truePwd = "";
		for (String i: pwd) {
			truePwd = truePwd + i;
		}
		return truePwd;
	}

	// Hashes a string and returns a String of the 128-bit hex value (0x00) of that hash
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

	// Finds if the hex of the hash meets the requirements
	private boolean validHash(String hash) {
		if (hash.charAt(5) > '7') {
			return false;
		}
		for (int i = 0; i < 5; i++) {
			if (hash.charAt(i) != '0') {
				return false;
			}
		}
		System.out.println(hash);
		System.out.println(hash.charAt(5) + "\n" + hash.charAt(6));
		System.out.println("Valid!");
		return true;
	}

	// Returns the hex value of an int as a String
	private static String hex(int n) {
    	return Integer.toHexString(n);
	}
}