import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.Math;

// TODO: This problem is way too slow, needs optimizing
public class Main {

	private static String input = "ugkcyxxp";
	private static MessageDigest md5;

	// Initiates an MD5 algorithm to be used in both parts
	// Prints the results from respective parts
	public static void main(String[] args) throws NoSuchAlgorithmException {
		md5 = MessageDigest.getInstance("MD5");
		Part01 part01 = new Part01(md5,input);
		System.out.println("Result from part 1: " + part01.run());

		Part02 part02 = new Part02(md5,input);
		System.out.println("Result from part 2: " + part02.run());
		// String t = "";
		// String dog = "The quick brown fox jumps over the lazy dog";
		// String dogg = "The quick brown fox jumps over the lazy dog.";
		// String s = "abc5017308";
		// t = hash(t);
		// s = hash(s);
		// dog = hash(dog);
		// dogg = hash(dogg);
		// System.out.println(t + "\nd41d8cd98f00b204e9800998ecf8427e" + "\n" +
		// 				   dog + "\n9e107d9d372bb6826bd81d3542a419d6" + "\n" +
		// 				   dogg + "\ne4d909c290d0fb1ca068ffaddf22cbd0" + "\n" +
		// 				   s + "\n000008f82...");
	}
}