package openrsc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;


public final class DataConversions {
	private static final char[] special_characters = "~`!@#$%^&*()_-+={}[]|\'\";:?><,./".toCharArray();
	private static char characters[] = {' ', 'e', 't', 'a', 'o', 'i',
		'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g',
		'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4',
		'5', '6', '7', '8', '9', ' ', '!', '?', '.', ',', ':', ';', '(',
		')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243', '$',
		'%', '"', '[', ']', '{', '}', '~', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
		'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
		'U', 'V', 'W', 'X', 'Y', 'Z', '<', '>', '^', '_', '|', '/'};
	private static final int bcryptWorkFactor = 10;
	private static final String bcryptTest = "$2y$"+bcryptWorkFactor+"$";
	private static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yy");
	private static MessageDigest md5, sha1, sha512;
	private static Random rand = new Random();
	private static SecureRandom secureRandom = new SecureRandom();

	/**
	 * Creates an instance of the message digest used for creating md5 hashes
	 */
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
			sha1 = MessageDigest.getInstance("SHA-1");
			sha512 = MessageDigest.getInstance("SHA-512");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Returns a virtual like influence from given quest points */
	public static int questPointsToInfluence(int numberPoints, int maxLevel) {
		// based on May 10 2001 conversion, about max influence 22 where max QP became 30
		return Math.min(Math.max(1, (int)Math.floor(numberPoints * 0.75)), maxLevel);
	}

	public static String getDateFromMsec(long diffMSec) {
		int left = 0;
		int ss = 0;
		int mm = 0;
		int hh = 0;
		int dd = 0;
		left = (int) (diffMSec / 1000);
		ss = left % 60;
		left = (int) left / 60;
		if (left > 0) {
			mm = left % 60;
			left = (int) left / 60;
			if (left > 0) {
				hh = left % 24;
				left = (int) left / 24;
				if (left > 0) {
					dd = left;
				}
			}
		}
		return Integer.toString(dd) + " days " + Integer.toString(hh) + " hours " + Integer.toString(mm)
			+ " minutes " + Integer.toString(ss) + " seconds";

	}

	/**
	 * returns the md5 hash of a string
	 */
	private static String md5(String s) {
		synchronized (md5) {
			md5.reset();
			md5.update(s.getBytes());
			return toHex(md5.digest());
		}
	}

	public static String sha1(String s) {
		synchronized (sha1) {
			sha1.reset();
			sha1.update(s.getBytes());
			return toHex(sha1.digest()).toLowerCase();
		}
	}

	private static String sha512(String s) {
		synchronized (sha512) {
			sha512.reset();
			sha512.update(s.getBytes());
			return toHex(sha512.digest()).toLowerCase();
		}
	}


	private static String toHex(byte[] bytes) {
		// change below to lower or uppercase X to control case of output
		return String.format("%0" + (bytes.length << 1) + "x", new BigInteger(1, bytes));
	}

	public static boolean isValidEmailAddress(String email) {
		boolean stricterFilter = true;
		String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
		String emailRegex = stricterFilter ? stricterFilterString : laxString;
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public static String updateIfEmpty(String checkedS, String otherS) {
		return (checkedS == null || checkedS.length() < 2) ? otherS : checkedS;
	}

	public static String normalize(String s, int len) {
		String res = addCharacters(s, len);
		res = res.replaceAll("[\\s_]+","_");
		char[] chars = res.trim().toCharArray();
		if (chars.length > 0 && chars[0] == '_')
			chars[0] = ' ';
		if (chars.length > 0 && chars[chars.length-1] == '_')
			chars[chars.length-1] = ' ';
		return String.valueOf(chars).toLowerCase().trim();
	}

	public static String maxLenString(String s, int len, boolean trim) {
		String res = s;
		if (trim) res = s.trim();
		if (res.length() > len) {
			res = res.substring(0, len);
		}
		return res;
	}

	public static String addCharacters(String s, int i) {
		String s1 = "";
		for (int j = 0; j < i; j++)
			if (j >= s.length()) {
				s1 = s1 + " ";
			} else {
				char c = s.charAt(j);
				if (c >= 'a' && c <= 'z')
					s1 = s1 + c;
				else if (c >= 'A' && c <= 'Z')
					s1 = s1 + c;
				else if (c >= '0' && c <= '9')
					s1 = s1 + c;
				else
					s1 = s1 + '_';
			}

		return s1;
	}

	public static int getDaysSinceTime(Long time) {
		long now = Calendar.getInstance().getTimeInMillis() / 1000;
		return (int) ((now - time) / 86400);
	}

	public static String stripBadCharacters(String value) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < value.length(); i++) {
			if (getCharCode(value.charAt(i)) > 0) {
				s.append(value.charAt(i));
			} else {
				s.append(" ");
			}
		}
		return s.toString();
	}

	public static String upperCaseAllFirst(String value) {

		// TODO: Code at some point before this should strip colour codes (to be put back in after).
		//   This is because the first letter of the string, regardless of colour codes, should be
		//   a capital letter. But unless we strip and replace codes, we can't find that as easily.
		//   Colour codes may also have capitals within them, regardless of position. Examples:
		//      @rAn@ , @RAN@ , @Ora@ , @orA@ , etc. for capitals in colour codes.
		//      @ran@------------This should be what the text looks like. Capital at beginning.

		Character[] array = value.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

		StringBuilder s = new StringBuilder();
		int i = 0;
		while (array[i].equals(" ") || !Character.isLetter(array[i])) { // Skip spaces and non-letters.
			s.append(String.valueOf(array[i]));
			i++;
			if (s.length() == array.length) return s.toString();
		}

		// Uppercase first letter.
		if (!Character.isUpperCase(array[i]))
			s.append(String.valueOf(Character.toUpperCase(array[i])));
		else
			s.append(String.valueOf(array[i]));

		i++;

		// Keep all letters that follow a whitespace character, if already capital, uppercase.
		// Also any character following a '.', '!', '?' should be transformed into a capital.
		// Also optionally any character following a:
		// "'", ":", "#", "@", "_", "-"
		// can be a capital if user entered.
		for (; i < array.length; i++) {
			Character c = array[i - 1];
			if (c.equals('.') || c.equals('!') || c.equals('?') ||
				((Character.isWhitespace(array[i - 1])
						|| c.equals('\'') || c.equals(':') || c.equals('_')
						|| c.equals('#') || c.equals('@') || c.equals('-')
						|| c.equals('/') || c.equals('\\') || c.equals('|'))
					&& Character.isUpperCase(array[i]))
				) {
				s.append(String.valueOf(Character.toUpperCase(array[i])));
			} else {
				s.append(String.valueOf(Character.toLowerCase(array[i])));
			}
		}

		return s.toString();
	}

	public static String speakTongues(String commonTongue) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		char[] vowelsUpper = {'A', 'E', 'I', 'O', 'U'};
		char[] babble = commonTongue.toCharArray();
		for (int idx = 0; idx < babble.length; idx++) {

			if (babble[idx] == '@') {
				idx += 5;
				if (idx >= babble.length) break;
			}

			if (random(0, random(7,13)) == 0) {
				babble[idx] = '\'';
			}

			switch (babble[idx]) {
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					babble[idx] = vowelsUpper[random(0,4)];
					break;
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					babble[idx] = vowels[random(0,4)];
					break;
				default:
					if (babble[idx] > 'A' && babble[idx] <= 'Z') {
						if (random(0,5) == 0) {
							babble[idx] = (char)random((int)'A', (int)'Z');
						}
					} else if (babble[idx] > 'a' && babble[idx] <= 'z') {
						if (random(0,5) == 0) {
							babble[idx] = (char)random((int)'a', (int)'z');
						}
					}
			}
		}
		return new String(babble);
	}

	/**
	 * Calculates the average of all values in the array
	 */
	public static int average(int[] values) {
		int total = 0;
		for (int value : values) {
			total += value;
		}
		return (int) (total / values.length);
	}

	/**
	 * returns the code used to represent the given character in our byte array
	 * encoding methods
	 */
	private static int getCharCode(char c) {
		for (int x = 0; x < characters.length; x++) {
			if (c == characters[x]) {
				return x;
			}
		}
		return 0;
	}

	private static byte getMobCoordOffset(int coord1, int coord2) {
		byte offset = (byte) (coord1 - coord2);
		if (offset < 0) {
			offset += 64;
		}
		return offset;
	}

	/**
	 * Returns the random number generator
	 */
	public static Random getRandom() {
		return rand;
	}

	public static int random(int range) {
		int number = (int) (Math.random() * (range + 1));
		return number < 0 ? 0 : number;
	}

	/**
	 * returns the max of the 2 values
	 */
	public static int max(int i1, int i2) {
		return i1 > i2 ? i1 : i2;
	}

	/**
	 * returns a random number within the given bounds
	 */
	public static double random(double low, double high) {
		return high - (rand.nextDouble() * low);
	}

	/**
	 * returns a random number within the given bounds
	 */
	public static int random(int low, int high) {
		return low + rand.nextInt(high - low + 1);
	}

	public static double round(double value, int decimalPlace) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(decimalPlace, RoundingMode.HALF_UP);
		return (bd.doubleValue());
	}

}
