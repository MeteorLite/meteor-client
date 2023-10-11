// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb

public class Definitions {

	public static int method123() {
		int i = aByteArray56[anInt57] & 0xff;
		anInt57++;
		return i;
	}

	public static int method124() {
		int i = DataUtils.method344(aByteArray56, anInt57);
		anInt57 += 2;
		return i;
	}

	public static int method125() {
		int i = DataUtils.method343(aByteArray56, anInt57);
		anInt57 += 4;
		if(i > 0x5f5e0ff)
			i = 0x5f5e0ff - i;
		return i;
	}

	public static String readString() {
		String s;
		for(s = ""; aByteArray58[anInt59] != 0; s = s + (char)aByteArray58[anInt59++]);
		anInt59++;
		return s;
	}

	public static int method127(String s) {
		if(s.equalsIgnoreCase("na"))
			return 0;
		for(int i = 0; i < anInt61; i++)
			if(aStringArray60[i].equalsIgnoreCase(s))
				return i;

		aStringArray60[anInt61++] = s;
		return anInt61 - 1;
	}

	public static void method128(byte[] abyte0, boolean flag) {
		aByteArray58 = DataUtils.loadData("string.dat", 0, abyte0);
		anInt59 = 0;
		aByteArray56 = DataUtils.loadData("integer.dat", 0, abyte0);
		anInt57 = 0;
		itemsSize = method124();
		itemNames = new String[itemsSize];
		aStringArray64 = new String[itemsSize];
		aStringArray65 = new String[itemsSize];
		anIntArray66 = new int[itemsSize];
		anIntArray67 = new int[itemsSize];
		inventoryItemsStackable = new int[itemsSize];
		anIntArray69 = new int[itemsSize];
		anIntArray70 = new int[itemsSize];
		anIntArray71 = new int[itemsSize];
		anIntArray72 = new int[itemsSize];
		anIntArray73 = new int[itemsSize];
		for(int i = 0; i < itemsSize; i++)
			itemNames[i] = readString();

		for(int j = 0; j < itemsSize; j++)
			aStringArray64[j] = readString();

		for(int k = 0; k < itemsSize; k++)
			aStringArray65[k] = readString();

		for(int l = 0; l < itemsSize; l++) {
			anIntArray66[l] = method124();
			if(anIntArray66[l] + 1 > anInt74)
				anInt74 = anIntArray66[l] + 1;
		}

		for(int i1 = 0; i1 < itemsSize; i1++)
			anIntArray67[i1] = method125();

		for(int j1 = 0; j1 < itemsSize; j1++)
			inventoryItemsStackable[j1] = method123();

		for(int k1 = 0; k1 < itemsSize; k1++)
			anIntArray69[k1] = method123();

		for(int l1 = 0; l1 < itemsSize; l1++)
			anIntArray70[l1] = method124();

		for(int i2 = 0; i2 < itemsSize; i2++)
			anIntArray71[i2] = method125();

		for(int j2 = 0; j2 < itemsSize; j2++)
			anIntArray72[j2] = method123();

		for(int k2 = 0; k2 < itemsSize; k2++)
			anIntArray73[k2] = method123();

		for(int l2 = 0; l2 < itemsSize; l2++)
			if(!flag && anIntArray73[l2] == 1) {
				itemNames[l2] = "Members object";
				aStringArray64[l2] = "You need to be a member to use this object";
				anIntArray67[l2] = 0;
				aStringArray65[l2] = "";
				anIntArray69[0] = 0;
				anIntArray70[l2] = 0;
				anIntArray72[l2] = 1;
			}

		anInt75 = method124();
		aStringArray76 = new String[anInt75];
		aStringArray77 = new String[anInt75];
		aStringArray78 = new String[anInt75];
		anIntArray79 = new int[anInt75];
		anIntArray80 = new int[anInt75];
		anIntArray81 = new int[anInt75];
		anIntArray82 = new int[anInt75];
		anIntArray83 = new int[anInt75];
		anIntArrayArray84 = new int[anInt75][12];
		anIntArray85 = new int[anInt75];
		anIntArray86 = new int[anInt75];
		anIntArray87 = new int[anInt75];
		anIntArray88 = new int[anInt75];
		anIntArray89 = new int[anInt75];
		anIntArray90 = new int[anInt75];
		anIntArray91 = new int[anInt75];
		anIntArray92 = new int[anInt75];
		anIntArray93 = new int[anInt75];
		for(int i3 = 0; i3 < anInt75; i3++)
			aStringArray76[i3] = readString();

		for(int j3 = 0; j3 < anInt75; j3++)
			aStringArray77[j3] = readString();

		for(int k3 = 0; k3 < anInt75; k3++)
			anIntArray79[k3] = method123();

		for(int l3 = 0; l3 < anInt75; l3++)
			anIntArray80[l3] = method123();

		for(int i4 = 0; i4 < anInt75; i4++)
			anIntArray81[i4] = method123();

		for(int j4 = 0; j4 < anInt75; j4++)
			anIntArray82[j4] = method123();

		for(int k4 = 0; k4 < anInt75; k4++)
			anIntArray83[k4] = method123();

		for(int l4 = 0; l4 < anInt75; l4++) {
			for(int i5 = 0; i5 < 12; i5++) {
				anIntArrayArray84[l4][i5] = method123();
				if(anIntArrayArray84[l4][i5] == 255)
					anIntArrayArray84[l4][i5] = -1;
			}

		}

		for(int j5 = 0; j5 < anInt75; j5++)
			anIntArray85[j5] = method125();

		for(int k5 = 0; k5 < anInt75; k5++)
			anIntArray86[k5] = method125();

		for(int l5 = 0; l5 < anInt75; l5++)
			anIntArray87[l5] = method125();

		for(int i6 = 0; i6 < anInt75; i6++)
			anIntArray88[i6] = method125();

		for(int j6 = 0; j6 < anInt75; j6++)
			anIntArray89[j6] = method124();

		for(int k6 = 0; k6 < anInt75; k6++)
			anIntArray90[k6] = method124();

		for(int l6 = 0; l6 < anInt75; l6++)
			anIntArray91[l6] = method123();

		for(int i7 = 0; i7 < anInt75; i7++)
			anIntArray92[i7] = method123();

		for(int j7 = 0; j7 < anInt75; j7++)
			anIntArray93[j7] = method123();

		for(int k7 = 0; k7 < anInt75; k7++)
			aStringArray78[k7] = readString();

		anInt94 = method124();
		aStringArray95 = new String[anInt94];
		aStringArray96 = new String[anInt94];
		for(int l7 = 0; l7 < anInt94; l7++)
			aStringArray95[l7] = readString();

		for(int i8 = 0; i8 < anInt94; i8++)
			aStringArray96[i8] = readString();

		anInt97 = method124();
		aStringArray98 = new String[anInt97];
		anIntArray99 = new int[anInt97];
		anIntArray100 = new int[anInt97];
		anIntArray101 = new int[anInt97];
		anIntArray102 = new int[anInt97];
		anIntArray103 = new int[anInt97];
		for(int j8 = 0; j8 < anInt97; j8++)
			aStringArray98[j8] = readString();

		for(int k8 = 0; k8 < anInt97; k8++)
			anIntArray99[k8] = method125();

		for(int l8 = 0; l8 < anInt97; l8++)
			anIntArray100[l8] = method123();

		for(int i9 = 0; i9 < anInt97; i9++)
			anIntArray101[i9] = method123();

		for(int j9 = 0; j9 < anInt97; j9++)
			anIntArray102[j9] = method123();

		for(int k9 = 0; k9 < anInt97; k9++)
			anIntArray103[k9] = method123();

		anInt104 = method124();
		aStringArray105 = new String[anInt104];
		aStringArray106 = new String[anInt104];
		aStringArray107 = new String[anInt104];
		aStringArray108 = new String[anInt104];
		anIntArray109 = new int[anInt104];
		anIntArray110 = new int[anInt104];
		anIntArray111 = new int[anInt104];
		anIntArray112 = new int[anInt104];
		anIntArray113 = new int[anInt104];
		for(int l9 = 0; l9 < anInt104; l9++)
			aStringArray105[l9] = readString();

		for(int i10 = 0; i10 < anInt104; i10++)
			aStringArray106[i10] = readString();

		for(int j10 = 0; j10 < anInt104; j10++)
			aStringArray107[j10] = readString();

		for(int k10 = 0; k10 < anInt104; k10++)
			aStringArray108[k10] = readString();

		for(int l10 = 0; l10 < anInt104; l10++)
			anIntArray109[l10] = method127(readString());

		for(int i11 = 0; i11 < anInt104; i11++)
			anIntArray110[i11] = method123();

		for(int j11 = 0; j11 < anInt104; j11++)
			anIntArray111[j11] = method123();

		for(int k11 = 0; k11 < anInt104; k11++)
			anIntArray112[k11] = method123();

		for(int l11 = 0; l11 < anInt104; l11++)
			anIntArray113[l11] = method123();

		anInt114 = method124();
		aStringArray115 = new String[anInt114];
		aStringArray116 = new String[anInt114];
		aStringArray117 = new String[anInt114];
		aStringArray118 = new String[anInt114];
		anIntArray119 = new int[anInt114];
		anIntArray120 = new int[anInt114];
		anIntArray121 = new int[anInt114];
		anIntArray122 = new int[anInt114];
		anIntArray123 = new int[anInt114];
		for(int i12 = 0; i12 < anInt114; i12++)
			aStringArray115[i12] = readString();

		for(int j12 = 0; j12 < anInt114; j12++)
			aStringArray116[j12] = readString();

		for(int k12 = 0; k12 < anInt114; k12++)
			aStringArray117[k12] = readString();

		for(int l12 = 0; l12 < anInt114; l12++)
			aStringArray118[l12] = readString();

		for(int i13 = 0; i13 < anInt114; i13++)
			anIntArray119[i13] = method124();

		for(int j13 = 0; j13 < anInt114; j13++)
			anIntArray120[j13] = method125();

		for(int k13 = 0; k13 < anInt114; k13++)
			anIntArray121[k13] = method125();

		for(int l13 = 0; l13 < anInt114; l13++)
			anIntArray122[l13] = method123();

		for(int i14 = 0; i14 < anInt114; i14++)
			anIntArray123[i14] = method123();

		anInt124 = method124();
		anIntArray125 = new int[anInt124];
		anIntArray126 = new int[anInt124];
		for(int j14 = 0; j14 < anInt124; j14++)
			anIntArray125[j14] = method123();

		for(int k14 = 0; k14 < anInt124; k14++)
			anIntArray126[k14] = method123();

		anInt127 = method124();
		anIntArray128 = new int[anInt127];
		anIntArray129 = new int[anInt127];
		anIntArray130 = new int[anInt127];
		for(int l14 = 0; l14 < anInt127; l14++)
			anIntArray128[l14] = method125();

		for(int i15 = 0; i15 < anInt127; i15++)
			anIntArray129[i15] = method123();

		for(int j15 = 0; j15 < anInt127; j15++)
			anIntArray130[j15] = method123();

		anInt131 = method124();
		anInt132 = method124();
		aStringArray133 = new String[anInt132];
		aStringArray134 = new String[anInt132];
		anIntArray135 = new int[anInt132];
		anIntArray136 = new int[anInt132];
		anIntArray137 = new int[anInt132];
		anIntArrayArray138 = new int[anInt132][];
		anIntArrayArray139 = new int[anInt132][];
		for(int k15 = 0; k15 < anInt132; k15++)
			aStringArray133[k15] = readString();

		for(int l15 = 0; l15 < anInt132; l15++)
			aStringArray134[l15] = readString();

		for(int i16 = 0; i16 < anInt132; i16++)
			anIntArray135[i16] = method123();

		for(int j16 = 0; j16 < anInt132; j16++)
			anIntArray136[j16] = method123();

		for(int k16 = 0; k16 < anInt132; k16++)
			anIntArray137[k16] = method123();

		for(int l16 = 0; l16 < anInt132; l16++) {
			int i17 = method123();
			anIntArrayArray138[l16] = new int[i17];
			for(int k17 = 0; k17 < i17; k17++)
				anIntArrayArray138[l16][k17] = method124();

		}

		for(int j17 = 0; j17 < anInt132; j17++) {
			int l17 = method123();
			anIntArrayArray139[j17] = new int[l17];
			for(int j18 = 0; j18 < l17; j18++)
				anIntArrayArray139[j17][j18] = method123();

		}

		anInt140 = method124();
		aStringArray141 = new String[anInt140];
		aStringArray142 = new String[anInt140];
		anIntArray143 = new int[anInt140];
		anIntArray144 = new int[anInt140];
		for(int i18 = 0; i18 < anInt140; i18++)
			aStringArray141[i18] = readString();

		for(int k18 = 0; k18 < anInt140; k18++)
			aStringArray142[k18] = readString();

		for(int l18 = 0; l18 < anInt140; l18++)
			anIntArray143[l18] = method123();

		for(int i19 = 0; i19 < anInt140; i19++)
			anIntArray144[i19] = method123();

		aByteArray58 = null;
		aByteArray56 = null;
		if(!DataUtils.aBoolean540);
	}

	public static String[] aStringArray53 = new String[5000];
	public static String[] aStringArray54 = new String[5000];
	public static int anInt55;
	static byte[] aByteArray56;
	static int anInt57;
	static byte[] aByteArray58;
	static int anInt59;
	public static String[] aStringArray60 = new String[5000];
	public static int anInt61;
	public static int itemsSize;
	public static String[] itemNames;
	public static String[] aStringArray64;
	public static String[] aStringArray65;
	public static int[] anIntArray66;
	public static int[] anIntArray67;
	public static int[] inventoryItemsStackable;
	public static int[] anIntArray69;
	public static int[] anIntArray70;
	public static int[] anIntArray71;
	public static int[] anIntArray72;
	public static int[] anIntArray73;
	public static int anInt74;
	public static int anInt75;
	public static String[] aStringArray76;
	public static String[] aStringArray77;
	public static String[] aStringArray78;
	public static int[] anIntArray79;
	public static int[] anIntArray80;
	public static int[] anIntArray81;
	public static int[] anIntArray82;
	public static int[] anIntArray83;
	public static int[][] anIntArrayArray84;
	public static int[] anIntArray85;
	public static int[] anIntArray86;
	public static int[] anIntArray87;
	public static int[] anIntArray88;
	public static int[] anIntArray89;
	public static int[] anIntArray90;
	public static int[] anIntArray91;
	public static int[] anIntArray92;
	public static int[] anIntArray93;
	public static int anInt94;
	public static String[] aStringArray95;
	public static String[] aStringArray96;
	public static int anInt97;
	public static String[] aStringArray98;
	public static int[] anIntArray99;
	public static int[] anIntArray100;
	public static int[] anIntArray101;
	public static int[] anIntArray102;
	public static int[] anIntArray103;
	public static int anInt104;
	public static String[] aStringArray105;
	public static String[] aStringArray106;
	public static String[] aStringArray107;
	public static String[] aStringArray108;
	public static int[] anIntArray109;
	public static int[] anIntArray110;
	public static int[] anIntArray111;
	public static int[] anIntArray112;
	public static int[] anIntArray113;
	public static int anInt114;
	public static String[] aStringArray115;
	public static String[] aStringArray116;
	public static String[] aStringArray117;
	public static String[] aStringArray118;
	public static int[] anIntArray119;
	public static int[] anIntArray120;
	public static int[] anIntArray121;
	public static int[] anIntArray122;
	public static int[] anIntArray123;
	public static int anInt124;
	public static int[] anIntArray125;
	public static int[] anIntArray126;
	public static int anInt127;
	public static int[] anIntArray128;
	public static int[] anIntArray129;
	public static int[] anIntArray130;
	public static int anInt131;
	public static int anInt132;
	public static String[] aStringArray133;
	public static String[] aStringArray134;
	public static int[] anIntArray135;
	public static int[] anIntArray136;
	public static int[] anIntArray137;
	public static int[][] anIntArrayArray138;
	public static int[][] anIntArrayArray139;
	public static int anInt140;
	public static String[] aStringArray141;
	public static String[] aStringArray142;
	public static int[] anIntArray143;
	public static int[] anIntArray144;

}
