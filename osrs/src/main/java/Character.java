// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import net.runelite.mapping.Implements;

@Implements("RSCharacter")
final class Character {

	Character() {
		waypointsX = new int[10];
		waypointsY = new int[10];
		equipment = new int[12];
		combatLevel = -1;
	}

	public long hash;
	public String name;
	public int serverIndex;
	public int serverID;
	public int currentX;
	public int currentY;
	public int npcID;
	public int stepCount;
	public int animation;
	public int nextAnimation;
	public int movingStep;
	public int waypointCurrent;
	public String message;
	public int messageTimeout;
	public int bubbleItem; //TODO: Show rares in bubble on drop
	public int bubbleTimeout;
	public int damageTaken;
	public int currentHealth;
	public int maxHealth;
	public int combatTimer;
	public int hairColor;
	public int topColor;
	public int bottomColor;
	public int skinColor;
	public int incomingProjectileSprite;
	public int attackingPlayerServerIndex;
	public int attackingNpcServerIndex;
	public int projectileRange;
	public int skullVisible;
	public int[] waypointsX;
	public int[] waypointsY;
	public int[] equipment;
	public int combatLevel;
}
