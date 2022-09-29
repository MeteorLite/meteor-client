package net.runelite.http.api.wiseoldman.model;

import net.runelite.api.Skill;

public class Snapshot {
  public String createdAt;
  public String importedAt;
  public SkillSnapshot overall;
  public SkillSnapshot attack;
  public SkillSnapshot defence;
  public SkillSnapshot strength;
  public SkillSnapshot hitpoints;
  public SkillSnapshot ranged;
  public SkillSnapshot prayer;
  public SkillSnapshot magic;
  public SkillSnapshot cooking;
  public SkillSnapshot woodcutting;
  public SkillSnapshot fletching;
  public SkillSnapshot fishing;
  public SkillSnapshot firemaking;
  public SkillSnapshot crafting;
  public SkillSnapshot smithing;
  public SkillSnapshot mining;
  public SkillSnapshot herblore;
  public SkillSnapshot agility;
  public SkillSnapshot thieving;
  public SkillSnapshot slayer;
  public SkillSnapshot farming;
  public SkillSnapshot runecrafting;
  public SkillSnapshot hunter;
  public SkillSnapshot construction;
  public int totalLevel = 0;
  public ScoreSnapshot leaguePoints = new ScoreSnapshot();
  public ScoreSnapshot bountyHunterHunter = new ScoreSnapshot();
  public ScoreSnapshot bountyHunterRogue = new ScoreSnapshot();
  public ScoreSnapshot clueScrollsAll = new ScoreSnapshot();
  public ScoreSnapshot clueScrollsEasy = new ScoreSnapshot();
  public ScoreSnapshot clueScrollsMed = new ScoreSnapshot();
  public ScoreSnapshot clueScrollsHard = new ScoreSnapshot();
  public ScoreSnapshot clueScrollsElite = new ScoreSnapshot();
  public ScoreSnapshot clueScrollsMaster = new ScoreSnapshot();
  public ScoreSnapshot lastManStanding = new ScoreSnapshot();
  public ScoreSnapshot soulWarsZeal = new ScoreSnapshot();
  public KillSnapshot abyssalSire = new KillSnapshot();
  public KillSnapshot alchemicalHydra = new KillSnapshot();
  public KillSnapshot barrowsChests = new KillSnapshot();
  public KillSnapshot bryophyta = new KillSnapshot();
  public KillSnapshot callisto = new KillSnapshot();
  public KillSnapshot cerberus = new KillSnapshot();
  public KillSnapshot cox = new KillSnapshot();
  public KillSnapshot coxChallenge = new KillSnapshot();
  public KillSnapshot chaosElemental = new KillSnapshot();
  public KillSnapshot chaosFanatic = new KillSnapshot();
  public KillSnapshot commanderZilyana = new KillSnapshot();
  public KillSnapshot corp = new KillSnapshot();
  public KillSnapshot crazyArch = new KillSnapshot();
  public KillSnapshot dagannothPrime = new KillSnapshot();
  public KillSnapshot dagannothRex = new KillSnapshot();
  public KillSnapshot dagannothSupreme = new KillSnapshot();
  public KillSnapshot derangedArch = new KillSnapshot();
  public KillSnapshot generalGraardor = new KillSnapshot();
  public KillSnapshot giantMole = new KillSnapshot();
  public KillSnapshot grotesqueGuardians = new KillSnapshot();
  public KillSnapshot hespori = new KillSnapshot();
  public KillSnapshot kalphiteQueen = new KillSnapshot();
  public KillSnapshot kbd = new KillSnapshot();
  public KillSnapshot kraken = new KillSnapshot();
  public KillSnapshot kreearra = new KillSnapshot();
  public KillSnapshot krilTsutsaroth = new KillSnapshot();
  public KillSnapshot mimic = new KillSnapshot();
  public KillSnapshot nightmare = new KillSnapshot();
  public KillSnapshot phosanisNightmare = new KillSnapshot();
  public KillSnapshot obor = new KillSnapshot();
  public KillSnapshot sarachnis = new KillSnapshot();
  public KillSnapshot scorpia = new KillSnapshot();
  public KillSnapshot skotizo = new KillSnapshot();
  public KillSnapshot tempoross = new KillSnapshot();
  public KillSnapshot theGauntlet = new KillSnapshot();
  public KillSnapshot theCorruptedGauntlet = new KillSnapshot();
  public KillSnapshot tob = new KillSnapshot();
  public KillSnapshot tobHard = new KillSnapshot();
  public KillSnapshot thermie = new KillSnapshot();
  public KillSnapshot zuk = new KillSnapshot();
  public KillSnapshot jad = new KillSnapshot();
  public KillSnapshot venenatis = new KillSnapshot();
  public KillSnapshot vetion = new KillSnapshot();
  public KillSnapshot vorkath = new KillSnapshot();
  public KillSnapshot wintertodt = new KillSnapshot();
  public KillSnapshot zalcano = new KillSnapshot();
  public KillSnapshot zulrah = new KillSnapshot();
  public EfficiencySnapshot efficiency;

  public SkillSnapshot getSnapshotFromSkill(Skill skill) {
    if (skill == Skill.ATTACK)
      return attack;
    else if (skill == Skill.DEFENCE)
      return defence;
    else if (skill == Skill.STRENGTH)
      return strength;
    else if (skill == Skill.HITPOINTS)
      return hitpoints;
    else if (skill == Skill.RANGED)
      return ranged;
    else if (skill == Skill.PRAYER)
      return prayer;
    else if (skill == Skill.MAGIC)
      return magic;
    else if (skill == Skill.COOKING)
      return cooking;
    else if (skill == Skill.WOODCUTTING)
      return woodcutting;
    else if (skill == Skill.FLETCHING)
      return fletching;
    else if (skill == Skill.FISHING)
      return fishing;
    else if (skill == Skill.FIREMAKING)
      return firemaking;
    else if (skill == Skill.CRAFTING)
      return crafting;
    else if (skill == Skill.SMITHING)
      return smithing;
    else if (skill == Skill.MINING)
      return mining;
    else if (skill == Skill.HERBLORE)
      return herblore;
    else if (skill == Skill.AGILITY)
      return agility;
    else if (skill == Skill.THIEVING)
      return thieving;
    else if (skill == Skill.SLAYER)
      return slayer;
    else if (skill == Skill.FARMING)
      return farming;
    else if (skill == Skill.RUNECRAFT)
      return runecrafting;
    else if (skill == Skill.HUNTER)
      return hunter;
    else if (skill == Skill.CONSTRUCTION)
      return construction;
    else if (skill == Skill.OVERALL)
      return overall;
    return null;
  }
}
