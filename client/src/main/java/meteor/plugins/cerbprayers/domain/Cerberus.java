package meteor.plugins.cerbprayers.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cerberus
{
  private static final int TOTAL_HP = 600;
  private static final int GHOST_HP = 400;
  private static final int LAVA_HP = 200;

  private final List<Phase> attacksDone;

  private final NPC npc;

  private int phaseCount;

  private int lastAttackTick;

  private Phase lastAttackPhase;

  private Attack lastAttack;

  @Setter
  private int lastGhostYellTick;

  @Setter
  private long lastGhostYellTime;

  @Setter
  private Attack lastTripleAttack;

  private int hp;

  public Cerberus(@NonNull final NPC npc)
  {
    this.npc = npc;

    attacksDone = new ArrayList<>();
    lastAttackPhase = Phase.SPAWNING;
    hp = TOTAL_HP;
  }

  public void nextPhase(final Phase lastAttackPhase)
  {
    phaseCount++;
    this.lastAttackPhase = lastAttackPhase;
  }

  public void doProjectileOrAnimation(final int gameTick, final Attack attack)
  {
    lastAttackTick = gameTick;
    lastAttack = attack;
  }

  public int getHp()
  {
    final var calcualtedHp = calculateNpcHp(npc.getHealthRatio(), npc.getHealthScale(), TOTAL_HP);

    if (calcualtedHp != -1)
    {
      hp = calcualtedHp;
    }

    return hp;
  }

  //https://pastebin.com/hWCvantS
  public Phase getNextAttackPhase(final int i, final int hp)
  {
    final var nextAttack = this.phaseCount + i;

    if (nextAttack == 0)
    {
      return Phase.SPAWNING;
    }

    if ((nextAttack - 1) % 10 == 0)
    {
      return Phase.TRIPLE;
    }

    if (nextAttack % 7 == 0 && hp <= GHOST_HP)
    {
      return Phase.GHOSTS;
    }

    if (nextAttack % 5 == 0 && hp <= LAVA_HP)
    {
      return Phase.LAVA;
    }

    return Phase.AUTO;
  }

  @Getter
  @RequiredArgsConstructor
  public enum Attack
  {
    SPAWN(null, 0),
    AUTO(null, 1),
    MELEE(Prayer.PROTECT_FROM_MELEE, 1),
    RANGED(Prayer.PROTECT_FROM_MISSILES, 1),
    MAGIC(Prayer.PROTECT_FROM_MAGIC, 1),
    LAVA(null, 0),
    GHOSTS(null, 0),
    GHOST_MELEE(Prayer.PROTECT_FROM_MELEE, 2),
    GHOST_RANGED(Prayer.PROTECT_FROM_MISSILES, 2),
    GHOST_MAGIC(Prayer.PROTECT_FROM_MAGIC, 2);

    private final Prayer prayer;

    private final int priority;
  }
  public static int calculateNpcHp(final int ratio, final int health, final int maxHp)
  {
    if (ratio < 0 || health <= 0 || maxHp == -1)
    {
      return -1;
    }

    int exactHealth = 0;

    // This is the reverse of the calculation of healthRatio done by the server
    // which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
    // It's able to recover the exact health if maxHealth <= healthScale.
    if (ratio > 0)
    {
      int minHealth = 1;
      int maxHealth;
      if (health > 1)
      {
        if (ratio > 1)
        {
          // This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
          // health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
          minHealth = (maxHp * (ratio - 1) + health - 2) / (health - 1);
        }
        maxHealth = (maxHp * ratio - 1) / (health - 1);
        if (maxHealth > maxHp)
        {
          maxHealth = maxHp;
        }
      }
      else
      {
        // If healthScale is 1, healthRatio will always be 1 unless health = 0
        // so we know nothing about the upper limit except that it can't be higher than maxHealth
        maxHealth = maxHp;
      }
      // Take the average of min and max possible healths
      exactHealth = (minHealth + maxHealth + 1) / 2;
    }

    return exactHealth;
  }

}