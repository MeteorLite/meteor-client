package net.runelite.http.api.wiseoldman.model;

import net.runelite.http.api.wiseoldman.model.Snapshot;

public class BasicResponse {
  public long exp;
  public int id;
  public String username;
  public String displayName;
  public String type;
  public String build;
  public String country;
  public boolean flagged;
  public double ehp;
  public double ehb;
  public double ttm;
  public double tt200m;
  public String lastImportedAt;
  public String lastChangedAt;
  public String registeredAt;
  public String updatedAt;
  public int combatLvl;
  public Snapshot latestSnapshot;

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(displayName).append("\n");
    builder.append(username).append("\n");
    builder.append(id).append("\n");
    builder.append(exp).append("\n");
    builder.append(type).append("\n");
    builder.append(build).append("\n");
    builder.append(country).append("\n");
    builder.append(flagged).append("\n");
    builder.append(ehp).append("\n");
    builder.append(ehb).append("\n");
    builder.append(ttm).append("\n");
    builder.append(tt200m).append("\n");
    builder.append(lastImportedAt).append("\n");
    builder.append(lastChangedAt).append("\n");
    builder.append(registeredAt).append("\n");
    builder.append(updatedAt).append("\n");
    builder.append(combatLvl).append("\n");
    return builder.toString();
  }
}
