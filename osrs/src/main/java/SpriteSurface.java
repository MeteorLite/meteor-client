// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import java.awt.Component;

public final class SpriteSurface extends Surface {

	public void method220(int i, int j, int k, int l, int i1, int j1, int k1) {
		if(i1 >= 50000) {
			aMudclient627.method48(i, j, k, l, i1 - 50000, j1, k1);
			return;
		}
		if(i1 >= 40000) {
			aMudclient627.method118(i, j, k, l, i1 - 40000, j1, k1);
			return;
		}
		if(i1 >= 20000) {
			aMudclient627.method51(i, j, k, l, i1 - 20000, j1, k1);
			return;
		}
		if(i1 >= 5000) {
			aMudclient627.method52(i, j, k, l, i1 - 5000, j1, k1);
        } else {
			super.method245(i, j, k, l, i1);
        }
	}

	public SpriteSurface(int i, int j, int k, Component component) {
		super(i, j, k, component);
		boolean flag = false;
		if(flag)
			new Surface(i, j, k, component);
	}

	public mudclient aMudclient627;
}
