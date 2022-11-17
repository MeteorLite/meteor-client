package net.runelite.client.plugins.zulrah.constants;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.jna.Platform;
import net.runelite.api.Skill;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;

import static net.runelite.client.plugins.zulrah.ZulrahPlugin.log;


public enum ZulrahType {
   RANGE("Range", 2042, Skill.RANGED, Color.YELLOW),
   MELEE("Melee", 2043, Skill.ATTACK, Color.RED),
   MAGIC("Magic", 2044, Skill.MAGIC, Color.CYAN);

  // private static final Logger log = Logger.getLogger(ZulrahType.class);
   private final String name;
   private final int npcId;
   private final Skill skill;
   private final Color color;

   public static ZulrahType valueOf(int npcId) {
      switch(npcId) {
      case 2042:
         return RANGE;
      case 2043:
         return MELEE;
      case 2044:
         return MAGIC;
      default:
         return null;
      }
   }

   public BufferedImage getImage() {
      try {
         return ZulrahPlugin.ZULRAH_IMAGES[this.ordinal()];
      } catch (ArrayIndexOutOfBoundsException var2) {

          log.info( "Attempted to get Zulrah Image but was out of bounds... Cause -> {}", var2.getMessage());
         return null;
      }
   }

   public Color getColorWithAlpha(int alpha) {
      return new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), alpha);
   }

   public String toString() {
      return this.name;
   }

   ZulrahType(String name, int npcId, Skill skill, Color color) {
      this.name = name;
      this.npcId = npcId;
      this.skill = skill;
      this.color = color;
   }

   public String getName() {
      return this.name;
   }

   public int getNpcId() {
      return this.npcId;
   }

   public Skill getSkill() {
      return this.skill;
   }

   public Color getColor() {
      return this.color;
   }
}
