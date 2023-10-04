// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 


public class ChatEncoding {

	public static String method388(byte abyte0[], int i, int j) {
		try {
			int k = 0;
			int l = -1;
			for(int i1 = 0; i1 < j; i1++) {
				int j1 = abyte0[i++] & 0xff;
				int k1 = j1 >> 4 & 0xf;
				if(l == -1) {
					if(k1 < 13)
						aCharArray555[k++] = aCharArray556[k1];
					else
						l = k1;
				} else {
					aCharArray555[k++] = aCharArray556[((l << 4) + k1) - 195];
					l = -1;
				}
				k1 = j1 & 0xf;
				if(l == -1) {
					if(k1 < 13)
						aCharArray555[k++] = aCharArray556[k1];
					else
						l = k1;
				} else {
					aCharArray555[k++] = aCharArray556[((l << 4) + k1) - 195];
					l = -1;
				}
			}

			boolean flag = true;
			for(int l1 = 0; l1 < k; l1++) {
				char c = aCharArray555[l1];
				if(l1 > 4 && c == '@')
					aCharArray555[l1] = ' ';
				if(c == '%')
					aCharArray555[l1] = ' ';
				if(flag && c >= 'a' && c <= 'z') {
					aCharArray555[l1] += '\uFFE0';
					flag = false;
				}
				if(c == '.' || c == '!')
					flag = true;
			}

			return new String(aCharArray555, 0, k);
		}
		catch(Exception _ex) {
			return ".";
		}
	}

	public static int method389(String s) {
		if(s.length() > 80)
			s = s.substring(0, 80);
		s = s.toLowerCase();
		int i = 0;
		int j = -1;
		for(int k = 0; k < s.length(); k++) {
			char c = s.charAt(k);
			int l = 0;
			for(int i1 = 0; i1 < aCharArray556.length; i1++) {
				if(c != aCharArray556[i1])
					continue;
				l = i1;
				break;
			}

			if(l > 12)
				l += 195;
			if(j == -1) {
				if(l < 13)
					j = l;
				else
					aByteArray557[i++] = (byte)l;
			} else
			if(l < 13) {
				aByteArray557[i++] = (byte)((j << 4) + l);
				j = -1;
			} else {
				aByteArray557[i++] = (byte)((j << 4) + (l >> 4));
				j = l & 0xf;
			}
		}

		if(j != -1)
			aByteArray557[i++] = (byte)(j << 4);
		return i;
	}

	public static char aCharArray555[] = new char[100];
	private static char aCharArray556[] = {
		' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 
		'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 
		'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', 
		'3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', 
		'.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', 
		'\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', 
		']'
	};
	public static byte aByteArray557[] = new byte[100];

}
