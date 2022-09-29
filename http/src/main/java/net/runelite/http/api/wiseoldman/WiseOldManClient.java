/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.api.wiseoldman;

import java.io.IOException;
import java.util.ArrayList;
import net.runelite.api.Skill;
import net.runelite.http.api.wiseoldman.model.BasicResponse;
import net.runelite.http.api.wiseoldman.model.EfficiencySnapshot;
import net.runelite.http.api.wiseoldman.model.KillSnapshot;
import net.runelite.http.api.wiseoldman.model.ScoreSnapshot;
import net.runelite.http.api.wiseoldman.model.SkillSnapshot;
import net.runelite.http.api.wiseoldman.model.Snapshot;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import meteor.Logger;

public class WiseOldManClient
{
	private static final String BASE = "https://api.wiseoldman.net";
	private static Logger log = Logger.Companion.getLogger(WiseOldManClient.class);
	private final OkHttpClient client = new OkHttpClient();
	public static HttpUrl getApiBase() {
		return HttpUrl.parse(BASE);
	}
	private String lastUsername;

	public void track(String username) {

		HttpUrl url = getApiBase().newBuilder()
				.addPathSegment("players")
				.addPathSegment("track")
				.build();

		RequestBody trackRequest = new FormBody.Builder()
				.add("username", username)
				.build();

		Request request = new Request.Builder()
				.url(url)
				.post(trackRequest)
				.build();

		log.error("Built URI: " + url.url());

		try (Response response = client.newCall(request).execute())
		{
			log.error(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BasicResponse lookup(String username) {
		lastUsername = username;
		HttpUrl url = getApiBase().newBuilder()
				.addPathSegment("players")
				.addPathSegment("username")
				.addPathSegment(username)
				.build();

		Request request = new Request.Builder()
				.url(url)
				.build();

		log.error("Built URI: " + url.url());

		try (Response response = client.newCall(request).execute())
		{
			String[] lines = response.body().string().split(",");
			ArrayList<String> cleanLines = new ArrayList<>();
			for (String s : lines)
				cleanLines.add(s.replace("{", "").replace("}", "").replace("\"", ""));

			return createBasicResponse(cleanLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//https://api.wiseoldman.net/players/username/IronTHCTrees/gained?period=year
	public ArrayList<Snapshot> lookupSnapshots(String username, Period period) {
		lastUsername = username;
		HttpUrl url = getApiBase().newBuilder()
				.addPathSegment("players")
				.addPathSegment("username")
				.addPathSegment(username)
				.addPathSegment("snapshots")
				.addQueryParameter("period", period.name)
				.build();

		Request request = new Request.Builder()
				.url(url)
				.build();

		log.error("Built URI: " + url.url());

		try (Response response = client.newCall(request).execute())
		{
			String[] lines = response.body().string().split(",");
			ArrayList<String> cleanLines = new ArrayList<>();
			for (String s : lines)
				cleanLines.add(s.replace("{", "").replace("}", "").replace("\"", ""));
			ArrayList<ArrayList<String>> snapshots = new ArrayList<>();
			ArrayList<String> snapshotLines = null;
			for (String s : cleanLines) {
				if (s.contains("createdAt")) {
					if (snapshotLines != null && !snapshotLines.isEmpty())
						snapshots.add(snapshotLines);
					snapshotLines = new ArrayList<>();
				}
				if (snapshotLines == null)
					return null;
				snapshotLines.add(s);
			}
			ArrayList<Snapshot> snapshotsList = new ArrayList<>();
			for (ArrayList<String> snap : snapshots) {
				Snapshot snapshot = getSnapShotFromLinesNoEHP(snap);
				snapshotsList.add(snapshot);
			}
			return snapshotsList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public BasicResponse createBasicResponse(ArrayList<String> cleanLines) {
		int ln = 1;
		BasicResponse response = new BasicResponse();
		ArrayList<String> snapshotLines = new ArrayList<>();
		for (String s : cleanLines) {
			if (s.contains("Player not found"))
				return null;
				switch (ln) {
					case 1 -> response.exp = Long.parseLong(s.split(":")[1]);
					case 2 -> response.id = Integer.parseInt(getValue(s));
					case 3 -> response.username = getValue(s);
					case 4 -> response.displayName = getValue(s);
					case 5 -> response.type = getValue(s);
					case 6 -> response.build = getValue(s);
					case 7 -> response.country = getValue(s);
					case 8 -> response.flagged = Boolean.parseBoolean(getValue(s));
					case 9 -> response.ehp = Double.parseDouble(getValue(s));
					case 10 -> response.ehb = Double.parseDouble(getValue(s));
					case 11 -> response.ttm = Double.parseDouble(getValue(s));
					case 12 -> response.tt200m = Double.parseDouble(getValue(s));
					case 13 -> response.lastImportedAt = getValue(s);
					case 14 -> response.lastChangedAt = getValue(s);
					case 15 -> response.registeredAt = getValue(s);
					case 16 -> response.updatedAt = getValue(s);
					case 17 -> {
						if (getValue(s).equals("null"))
							response.combatLvl = -1;
						else
							response.combatLvl = Integer.parseInt(getValue(s));
					}
					default -> snapshotLines.add(s);
				}
				ln++;
		}
		response.latestSnapshot = getSnapShotFromLines(snapshotLines);
		return response;
	}

	public Snapshot getSnapShotFromLines(ArrayList<String> snapshotLines) {
		Snapshot snapshot = new Snapshot();
		int ln = 1;
		SkillSnapshot overallSnapshot = new SkillSnapshot();
		SkillSnapshot attackSnapshot = new SkillSnapshot();
		SkillSnapshot defenceSnapshot = new SkillSnapshot();
		SkillSnapshot strengthSnapshot = new SkillSnapshot();
		SkillSnapshot hitpointsSnapshot = new SkillSnapshot();
		SkillSnapshot rangedSnapshot = new SkillSnapshot();
		SkillSnapshot prayerSnapshot = new SkillSnapshot();
		SkillSnapshot magicSnapshot = new SkillSnapshot();
		SkillSnapshot cookingSnapshot = new SkillSnapshot();
		SkillSnapshot woodcuttingSnapshot = new SkillSnapshot();
		SkillSnapshot fletchingSnapshot = new SkillSnapshot();
		SkillSnapshot fishingSnapshot = new SkillSnapshot();
		SkillSnapshot firemakingSnapshot = new SkillSnapshot();
		SkillSnapshot craftingSnapshot = new SkillSnapshot();
		SkillSnapshot smithingSnapshot = new SkillSnapshot();
		SkillSnapshot miningSnapshot = new SkillSnapshot();
		SkillSnapshot herbloreSnapshot = new SkillSnapshot();
		SkillSnapshot agilitySnapshot = new SkillSnapshot();
		SkillSnapshot thievingSnapshot = new SkillSnapshot();
		SkillSnapshot slayerSnapshot = new SkillSnapshot();
		SkillSnapshot farmingSnapshot = new SkillSnapshot();
		SkillSnapshot runecraftingSnapshot = new SkillSnapshot();
		SkillSnapshot hunterSnapshot = new SkillSnapshot();
		SkillSnapshot constructionSnapshot = new SkillSnapshot();
		EfficiencySnapshot efficiencySnapshot = new EfficiencySnapshot();
		for (String s : snapshotLines) {
			if (s.contains("latestSnapshot:null")) {
				track(lastUsername);
			}
			switch (ln) {
				case 1 -> snapshot.createdAt = s.split(":")[1];
				case 2 -> snapshot.importedAt = getValue(s);
				case 3 -> {
					overallSnapshot.skill = Skill.OVERALL;
					overallSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 4 ->	overallSnapshot.xp = Long.parseLong(s.split(":")[1]);
				case 5 ->	overallSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 6 -> {
					attackSnapshot.skill = Skill.ATTACK;
					attackSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 7 ->	attackSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 8 ->	attackSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 9 -> {
					defenceSnapshot.skill = Skill.DEFENCE;
					defenceSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 10 ->	defenceSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 11 ->	defenceSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 12 -> {
					strengthSnapshot.skill = Skill.STRENGTH;
					strengthSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 13 ->	strengthSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 14 ->	strengthSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 15 -> {
					hitpointsSnapshot.skill = Skill.HITPOINTS;
					hitpointsSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 16 ->	hitpointsSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 17 ->	hitpointsSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 18 -> {
					rangedSnapshot.skill = Skill.RANGED;
					rangedSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 19 ->	rangedSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 20 ->	rangedSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 21 -> {
					prayerSnapshot.skill = Skill.PRAYER;
					prayerSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 22 ->	prayerSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 23 ->	prayerSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 24 -> {
					magicSnapshot.skill = Skill.MAGIC;
					magicSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 25	->  magicSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 26 ->	magicSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 27 -> {
					cookingSnapshot.skill = Skill.COOKING;
					cookingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 28 ->	cookingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 29 ->	cookingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 30 -> {
					woodcuttingSnapshot.skill = Skill.WOODCUTTING;
					woodcuttingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 31 ->	woodcuttingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 32 ->	woodcuttingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 33 -> {
					fletchingSnapshot.skill = Skill.FLETCHING;
					fletchingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 34 ->	fletchingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 35 ->	fletchingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 36 -> {
					fishingSnapshot.skill = Skill.FISHING;
					fishingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 37 ->	fishingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 38 ->	fishingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 39 -> {
					firemakingSnapshot.skill = Skill.FIREMAKING;
					firemakingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 40 ->	firemakingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 41 ->	firemakingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 42 -> {
					craftingSnapshot.skill = Skill.CRAFTING;
					craftingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 43 ->	craftingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 44 ->	craftingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 45 -> {
					smithingSnapshot.skill = Skill.SMITHING;
					smithingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 46 ->	smithingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 47 ->	smithingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 48 -> {
					miningSnapshot.skill = Skill.MINING;
					miningSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 49 ->	miningSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 50 ->	miningSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 51 -> {
					herbloreSnapshot.skill = Skill.HERBLORE;
					herbloreSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 52 ->	herbloreSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 53 ->	herbloreSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 54 -> {
					agilitySnapshot.skill = Skill.AGILITY;
					agilitySnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 55 ->	agilitySnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 56 ->	agilitySnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 57 -> {
					thievingSnapshot.skill = Skill.THIEVING;
					thievingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 58 ->	thievingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 59 ->	thievingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 60 -> {
					slayerSnapshot.skill = Skill.SLAYER;
					slayerSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 61 ->	slayerSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 62 ->	slayerSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 63 -> {
					farmingSnapshot.skill = Skill.FARMING;
					farmingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 64 ->	farmingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 65 ->	farmingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 66 -> {
					runecraftingSnapshot.skill = Skill.RUNECRAFT;
					runecraftingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 67 ->	runecraftingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 68 ->	runecraftingSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 69 -> {
					hunterSnapshot.skill = Skill.HUNTER;
					hunterSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 70 ->	hunterSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 71 ->	hunterSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 72 -> {
					constructionSnapshot.skill = Skill.CONSTRUCTION;
					constructionSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 73 ->	constructionSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 74 ->	constructionSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 75 -> 	snapshot.leaguePoints.rank = Integer.parseInt(s.split(":")[2]);
				case 76 -> 	snapshot.leaguePoints.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 77 -> 	snapshot.leaguePoints.rank = Integer.parseInt(s.split(":")[2]);
				case 78 -> 	snapshot.leaguePoints.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 79 -> 	snapshot.bountyHunterHunter.rank = Integer.parseInt(s.split(":")[2]);
				case 80 -> 	snapshot.bountyHunterHunter.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 81 -> 	snapshot.bountyHunterRogue.rank = Integer.parseInt(s.split(":")[2]);
				case 82 -> 	snapshot.bountyHunterRogue.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 83 -> 	snapshot.clueScrollsAll.rank = Integer.parseInt(s.split(":")[2]);
				case 84 -> 	snapshot.clueScrollsAll.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 85 -> 	snapshot.clueScrollsEasy.rank = Integer.parseInt(s.split(":")[2]);
				case 86 -> 	snapshot.clueScrollsEasy.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 87 -> 	snapshot.clueScrollsMed.rank = Integer.parseInt(s.split(":")[2]);
				case 88 -> 	snapshot.clueScrollsMed.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 89 -> 	snapshot.clueScrollsHard.rank = Integer.parseInt(s.split(":")[2]);
				case 90 -> 	snapshot.clueScrollsHard.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 91 -> 	snapshot.clueScrollsElite.rank = Integer.parseInt(s.split(":")[2]);
				case 92 -> 	snapshot.clueScrollsElite.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 93 -> 	snapshot.clueScrollsMaster.rank = Integer.parseInt(s.split(":")[2]);
				case 94 -> 	snapshot.clueScrollsMaster.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 95 -> 	snapshot.lastManStanding.rank = Integer.parseInt(s.split(":")[2]);
				case 96 -> 	snapshot.lastManStanding.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 97 -> 	snapshot.soulWarsZeal.rank = Integer.parseInt(s.split(":")[2]);
				case 98 -> 	snapshot.soulWarsZeal.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 99 -> 	snapshot.abyssalSire.rank = Integer.parseInt(s.split(":")[2]);
				case 100 -> 	snapshot.abyssalSire.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 101 -> 	snapshot.abyssalSire.ehb = Double.parseDouble(s.split(":")[1]);
				case 102 -> 	snapshot.alchemicalHydra.rank = Integer.parseInt(s.split(":")[2]);
				case 103 -> 	snapshot.alchemicalHydra.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 104 -> 	snapshot.alchemicalHydra.ehb = Double.parseDouble(s.split(":")[1]);
				case 105 -> 	snapshot.barrowsChests.rank = Integer.parseInt(s.split(":")[2]);
				case 106 -> 	snapshot.barrowsChests.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 107 -> 	snapshot.barrowsChests.ehb = Double.parseDouble(s.split(":")[1]);
				case 108 -> 	snapshot.bryophyta.rank = Integer.parseInt(s.split(":")[2]);
				case 109 -> 	snapshot.bryophyta.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 110 -> 	snapshot.bryophyta.ehb = Double.parseDouble(s.split(":")[1]);
				case 111 -> 	snapshot.callisto.rank = Integer.parseInt(s.split(":")[2]);
				case 112 -> 	snapshot.callisto.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 113 -> 	snapshot.callisto.ehb = Double.parseDouble(s.split(":")[1]);
				case 114 -> 	snapshot.cerberus.rank = Integer.parseInt(s.split(":")[2]);
				case 115 -> 	snapshot.cerberus.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 116 -> 	snapshot.cerberus.ehb = Double.parseDouble(s.split(":")[1]);
				case 117 -> 	snapshot.cox.rank = Integer.parseInt(s.split(":")[2]);
				case 118 -> 	snapshot.cox.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 119 -> 	snapshot.cox.ehb = Double.parseDouble(s.split(":")[1]);
				case 120 -> 	snapshot.coxChallenge.rank = Integer.parseInt(s.split(":")[2]);
				case 121 -> 	snapshot.coxChallenge.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 122 -> 	snapshot.coxChallenge.ehb = Double.parseDouble(s.split(":")[1]);
				case 123 -> 	snapshot.chaosElemental.rank = Integer.parseInt(s.split(":")[2]);
				case 124 -> 	snapshot.chaosElemental.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 125 -> 	snapshot.chaosElemental.ehb = Double.parseDouble(s.split(":")[1]);
				case 126 -> 	snapshot.chaosFanatic.rank = Integer.parseInt(s.split(":")[2]);
				case 127 -> 	snapshot.chaosFanatic.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 128 -> 	snapshot.chaosFanatic.ehb = Double.parseDouble(s.split(":")[1]);
				case 129 -> 	snapshot.commanderZilyana.rank = Integer.parseInt(s.split(":")[2]);
				case 130 -> 	snapshot.commanderZilyana.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 131 -> 	snapshot.commanderZilyana.ehb = Double.parseDouble(s.split(":")[1]);
				case 132 -> 	snapshot.corp.rank = Integer.parseInt(s.split(":")[2]);
				case 133 -> 	snapshot.corp.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 134 -> 	snapshot.corp.ehb = Double.parseDouble(s.split(":")[1]);
				case 135 -> 	snapshot.crazyArch.rank = Integer.parseInt(s.split(":")[2]);
				case 136 -> 	snapshot.crazyArch.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 137 -> 	snapshot.crazyArch.ehb = Double.parseDouble(s.split(":")[1]);
				case 138 -> 	snapshot.dagannothPrime.rank = Integer.parseInt(s.split(":")[2]);
				case 139 -> 	snapshot.dagannothPrime.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 140 -> 	snapshot.dagannothPrime.ehb = Double.parseDouble(s.split(":")[1]);
				case 141 -> 	snapshot.dagannothRex.rank = Integer.parseInt(s.split(":")[2]);
				case 142 -> 	snapshot.dagannothRex.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 143 -> 	snapshot.dagannothRex.ehb = Double.parseDouble(s.split(":")[1]);
				case 144 -> 	snapshot.dagannothSupreme.rank = Integer.parseInt(s.split(":")[2]);
				case 145 -> 	snapshot.dagannothSupreme.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 146 -> 	snapshot.dagannothSupreme.ehb = Double.parseDouble(s.split(":")[1]);
				case 147 -> 	snapshot.derangedArch.rank = Integer.parseInt(s.split(":")[2]);
				case 148 -> 	snapshot.derangedArch.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 149 -> 	snapshot.derangedArch.ehb = Double.parseDouble(s.split(":")[1]);
				case 150 -> 	snapshot.generalGraardor.rank = Integer.parseInt(s.split(":")[2]);
				case 151 -> 	snapshot.generalGraardor.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 152 -> 	snapshot.generalGraardor.ehb = Double.parseDouble(s.split(":")[1]);
				case 153 -> 	snapshot.giantMole.rank = Integer.parseInt(s.split(":")[2]);
				case 154 -> 	snapshot.giantMole.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 155 -> 	snapshot.giantMole.ehb = Double.parseDouble(s.split(":")[1]);
				case 156 -> 	snapshot.grotesqueGuardians.rank = Integer.parseInt(s.split(":")[2]);
				case 157 -> 	snapshot.grotesqueGuardians.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 158 -> 	snapshot.grotesqueGuardians.ehb = Double.parseDouble(s.split(":")[1]);
				case 159 -> 	snapshot.hespori.rank = Integer.parseInt(s.split(":")[2]);
				case 160 -> 	snapshot.hespori.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 161 -> 	snapshot.hespori.ehb = Double.parseDouble(s.split(":")[1]);
				case 162 -> 	snapshot.kalphiteQueen.rank = Integer.parseInt(s.split(":")[2]);
				case 163 -> 	snapshot.kalphiteQueen.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 164 -> 	snapshot.kalphiteQueen.ehb = Double.parseDouble(s.split(":")[1]);
				case 165 -> 	snapshot.kbd.rank = Integer.parseInt(s.split(":")[2]);
				case 166 -> 	snapshot.kbd.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 167 -> 	snapshot.kbd.ehb = Double.parseDouble(s.split(":")[1]);
				case 168 -> 	snapshot.kraken.rank = Integer.parseInt(s.split(":")[2]);
				case 169 -> 	snapshot.kraken.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 170 -> 	snapshot.kraken.ehb = Double.parseDouble(s.split(":")[1]);
				case 171 -> 	snapshot.kreearra.rank = Integer.parseInt(s.split(":")[2]);
				case 172 -> 	snapshot.kreearra.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 173 -> 	snapshot.kreearra.ehb = Double.parseDouble(s.split(":")[1]);
				case 174 -> 	snapshot.krilTsutsaroth.rank = Integer.parseInt(s.split(":")[2]);
				case 175 -> 	snapshot.krilTsutsaroth.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 176 -> 	snapshot.krilTsutsaroth.ehb = Double.parseDouble(s.split(":")[1]);
				case 177 -> 	snapshot.mimic.rank = Integer.parseInt(s.split(":")[2]);
				case 178 -> 	snapshot.mimic.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 179 -> 	snapshot.mimic.ehb = Double.parseDouble(s.split(":")[1]);
				case 180 -> 	snapshot.nightmare.rank = Integer.parseInt(s.split(":")[2]);
				case 181 -> 	snapshot.nightmare.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 182 -> 	snapshot.nightmare.ehb = Double.parseDouble(s.split(":")[1]);
				case 183 -> 	snapshot.phosanisNightmare.rank = Integer.parseInt(s.split(":")[2]);
				case 184 -> 	snapshot.phosanisNightmare.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 185 -> 	snapshot.phosanisNightmare.ehb = Double.parseDouble(s.split(":")[1]);
				case 186 -> 	snapshot.obor.rank = Integer.parseInt(s.split(":")[2]);
				case 187 -> 	snapshot.obor.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 188 -> 	snapshot.obor.ehb = Double.parseDouble(s.split(":")[1]);
				case 189 -> 	snapshot.sarachnis.rank = Integer.parseInt(s.split(":")[2]);
				case 190 -> 	snapshot.sarachnis.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 191 -> 	snapshot.sarachnis.ehb = Double.parseDouble(s.split(":")[1]);
				case 192 -> 	snapshot.scorpia.rank = Integer.parseInt(s.split(":")[2]);
				case 193 -> 	snapshot.scorpia.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 194 -> 	snapshot.scorpia.ehb = Double.parseDouble(s.split(":")[1]);
				case 195 -> 	snapshot.skotizo.rank = Integer.parseInt(s.split(":")[2]);
				case 196 -> 	snapshot.skotizo.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 197 -> 	snapshot.skotizo.ehb = Double.parseDouble(s.split(":")[1]);
				case 198 -> 	snapshot.tempoross.rank = Integer.parseInt(s.split(":")[2]);
				case 199 -> 	snapshot.tempoross.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 200 -> 	snapshot.tempoross.ehb = Double.parseDouble(s.split(":")[1]);
				case 201 -> 	snapshot.theGauntlet.rank = Integer.parseInt(s.split(":")[2]);
				case 202 -> 	snapshot.theGauntlet.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 203 -> 	snapshot.theGauntlet.ehb = Double.parseDouble(s.split(":")[1]);
				case 204 -> 	snapshot.theCorruptedGauntlet.rank = Integer.parseInt(s.split(":")[2]);
				case 205 -> 	snapshot.theCorruptedGauntlet.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 206 -> 	snapshot.theCorruptedGauntlet.ehb = Double.parseDouble(s.split(":")[1]);
				case 207 -> 	snapshot.tob.rank = Integer.parseInt(s.split(":")[2]);
				case 208 -> 	snapshot.tob.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 209 -> 	snapshot.tob.ehb = Double.parseDouble(s.split(":")[1]);
				case 210 -> 	snapshot.tobHard.rank = Integer.parseInt(s.split(":")[2]);
				case 211 -> 	snapshot.tobHard.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 212 -> 	snapshot.tobHard.ehb = Double.parseDouble(s.split(":")[1]);
				case 213 -> 	snapshot.thermie.rank = Integer.parseInt(s.split(":")[2]);
				case 214 -> 	snapshot.thermie.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 215 -> 	snapshot.thermie.ehb = Double.parseDouble(s.split(":")[1]);
				case 216 -> 	snapshot.zuk.rank = Integer.parseInt(s.split(":")[2]);
				case 217 -> 	snapshot.zuk.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 218 -> 	snapshot.zuk.ehb = Double.parseDouble(s.split(":")[1]);
				case 219 -> 	snapshot.jad.rank = Integer.parseInt(s.split(":")[2]);
				case 220 -> 	snapshot.jad.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 221 -> 	snapshot.jad.ehb = Double.parseDouble(s.split(":")[1]);
				case 222 -> 	snapshot.venenatis.rank = Integer.parseInt(s.split(":")[2]);
				case 223 -> 	snapshot.venenatis.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 224 -> 	snapshot.venenatis.ehb = Double.parseDouble(s.split(":")[1]);
				case 225 -> 	snapshot.vetion.rank = Integer.parseInt(s.split(":")[2]);
				case 226 -> 	snapshot.vetion.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 227 -> 	snapshot.vetion.ehb = Double.parseDouble(s.split(":")[1]);
				case 228 -> 	snapshot.vorkath.rank = Integer.parseInt(s.split(":")[2]);
				case 229 -> 	snapshot.vorkath.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 230 -> 	snapshot.vorkath.ehb = Double.parseDouble(s.split(":")[1]);
				case 231 -> 	snapshot.wintertodt.rank = Integer.parseInt(s.split(":")[2]);
				case 232 -> 	snapshot.wintertodt.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 233 -> 	snapshot.wintertodt.ehb = Double.parseDouble(s.split(":")[1]);
				case 234 -> 	snapshot.zalcano.rank = Integer.parseInt(s.split(":")[2]);
				case 235 -> 	snapshot.zalcano.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 236 -> 	snapshot.zalcano.ehb = Double.parseDouble(s.split(":")[1]);
				case 237 -> 	snapshot.zulrah.rank = Integer.parseInt(s.split(":")[2]);
				case 238 -> 	snapshot.zulrah.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 239 -> 	snapshot.zulrah.ehb = Double.parseDouble(s.split(":")[1]);

			}
			ln++;
		}
		snapshot.overall = overallSnapshot;
		attackSnapshot.lvl = XpTable.of((int) attackSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(attackSnapshot.lvl, 99);
		snapshot.attack = attackSnapshot;
		defenceSnapshot.lvl = XpTable.of((int) defenceSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(defenceSnapshot.lvl, 99);
		snapshot.defence = defenceSnapshot;
		strengthSnapshot.lvl = XpTable.of((int) strengthSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(strengthSnapshot.lvl, 99);
		snapshot.strength = strengthSnapshot;
		hitpointsSnapshot.lvl = XpTable.of((int) hitpointsSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(hitpointsSnapshot.lvl, 99);
		snapshot.hitpoints = hitpointsSnapshot;
		rangedSnapshot.lvl = XpTable.of((int) rangedSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(rangedSnapshot.lvl, 99);
		snapshot.ranged = rangedSnapshot;
		prayerSnapshot.lvl = XpTable.of((int) prayerSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(prayerSnapshot.lvl, 99);
		snapshot.prayer = prayerSnapshot;
		magicSnapshot.lvl = XpTable.of((int) magicSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(magicSnapshot.lvl, 99);
		snapshot.magic = magicSnapshot;
		cookingSnapshot.lvl = XpTable.of((int) cookingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(cookingSnapshot.lvl, 99);
		snapshot.cooking = cookingSnapshot;
		woodcuttingSnapshot.lvl = XpTable.of((int) woodcuttingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(woodcuttingSnapshot.lvl, 99);
		snapshot.woodcutting = woodcuttingSnapshot;
		fletchingSnapshot.lvl = XpTable.of((int) fletchingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(fletchingSnapshot.lvl, 99);
		snapshot.fletching = fletchingSnapshot;
		fishingSnapshot.lvl = XpTable.of((int) fishingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(fishingSnapshot.lvl, 99);
		snapshot.fishing = fishingSnapshot;
		firemakingSnapshot.lvl = XpTable.of((int) firemakingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(firemakingSnapshot.lvl, 99);
		snapshot.firemaking = firemakingSnapshot;
		craftingSnapshot.lvl = XpTable.of((int) craftingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(craftingSnapshot.lvl, 99);
		snapshot.crafting = craftingSnapshot;
		smithingSnapshot.lvl = XpTable.of((int) smithingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(smithingSnapshot.lvl, 99);
		snapshot.smithing = smithingSnapshot;
		miningSnapshot.lvl = XpTable.of((int) miningSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(miningSnapshot.lvl, 99);
		snapshot.mining = miningSnapshot;
		herbloreSnapshot.lvl = XpTable.of((int) herbloreSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(herbloreSnapshot.lvl, 99);
		snapshot.herblore = herbloreSnapshot;
		agilitySnapshot.lvl = XpTable.of((int) agilitySnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(agilitySnapshot.lvl, 99);
		snapshot.agility = agilitySnapshot;
		thievingSnapshot.lvl = XpTable.of((int) thievingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(thievingSnapshot.lvl, 99);
		snapshot.thieving = thievingSnapshot;
		slayerSnapshot.lvl = XpTable.of((int) slayerSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(slayerSnapshot.lvl, 99);
		snapshot.slayer = slayerSnapshot;
		farmingSnapshot.lvl = XpTable.of((int) farmingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(farmingSnapshot.lvl, 99);
		snapshot.farming = farmingSnapshot;
		runecraftingSnapshot.lvl = XpTable.of((int) runecraftingSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(runecraftingSnapshot.lvl, 99);
		snapshot.runecrafting = runecraftingSnapshot;
		hunterSnapshot.lvl = XpTable.of((int) hunterSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(hunterSnapshot.lvl, 99);
		snapshot.hunter = hunterSnapshot;
		constructionSnapshot.lvl = XpTable.of((int) constructionSnapshot.xp).lvl;
		snapshot.overall.lvl += Math.min(constructionSnapshot.lvl, 99);
		snapshot.construction = constructionSnapshot;
		return snapshot;
	}

	public Snapshot getSnapShotFromLinesNoEHP(ArrayList<String> snapshotLines) {
		Snapshot snapshot = new Snapshot();
		int ln = 1;
		SkillSnapshot overallSnapshot = new SkillSnapshot();
		SkillSnapshot attackSnapshot = new SkillSnapshot();
		SkillSnapshot defenceSnapshot = new SkillSnapshot();
		SkillSnapshot strengthSnapshot = new SkillSnapshot();
		SkillSnapshot hitpointsSnapshot = new SkillSnapshot();
		SkillSnapshot rangedSnapshot = new SkillSnapshot();
		SkillSnapshot prayerSnapshot = new SkillSnapshot();
		SkillSnapshot magicSnapshot = new SkillSnapshot();
		SkillSnapshot cookingSnapshot = new SkillSnapshot();
		SkillSnapshot woodcuttingSnapshot = new SkillSnapshot();
		SkillSnapshot fletchingSnapshot = new SkillSnapshot();
		SkillSnapshot fishingSnapshot = new SkillSnapshot();
		SkillSnapshot firemakingSnapshot = new SkillSnapshot();
		SkillSnapshot craftingSnapshot = new SkillSnapshot();
		SkillSnapshot smithingSnapshot = new SkillSnapshot();
		SkillSnapshot miningSnapshot = new SkillSnapshot();
		SkillSnapshot herbloreSnapshot = new SkillSnapshot();
		SkillSnapshot agilitySnapshot = new SkillSnapshot();
		SkillSnapshot thievingSnapshot = new SkillSnapshot();
		SkillSnapshot slayerSnapshot = new SkillSnapshot();
		SkillSnapshot farmingSnapshot = new SkillSnapshot();
		SkillSnapshot runecraftingSnapshot = new SkillSnapshot();
		SkillSnapshot hunterSnapshot = new SkillSnapshot();
		SkillSnapshot constructionSnapshot = new SkillSnapshot();
		ScoreSnapshot leaguePoints = new ScoreSnapshot();
		ScoreSnapshot bountyHunterHunter = new ScoreSnapshot();
		ScoreSnapshot bountyHunterRogue = new ScoreSnapshot();
		ScoreSnapshot clueScrollsAll = new ScoreSnapshot();
		ScoreSnapshot clueScrollsEasy = new ScoreSnapshot();
		ScoreSnapshot clueScrollsMed = new ScoreSnapshot();
		ScoreSnapshot clueScrollsHard = new ScoreSnapshot();
		ScoreSnapshot clueScrollsElite = new ScoreSnapshot();
		ScoreSnapshot clueScrollsMaster = new ScoreSnapshot();
		ScoreSnapshot lastManStanding = new ScoreSnapshot();
		ScoreSnapshot soulWarsZeal = new ScoreSnapshot();
		KillSnapshot abyssalSire = new KillSnapshot();
		KillSnapshot alchemicalHydra = new KillSnapshot();
		KillSnapshot barrowsChests = new KillSnapshot();
		KillSnapshot bryophyta = new KillSnapshot();
		KillSnapshot callisto = new KillSnapshot();
		KillSnapshot cerberus = new KillSnapshot();
		KillSnapshot cox = new KillSnapshot();
		KillSnapshot coxChallenge = new KillSnapshot();
		KillSnapshot chaosElemental = new KillSnapshot();
		KillSnapshot chaosFanatic = new KillSnapshot();
		KillSnapshot commanderZilyana = new KillSnapshot();
		KillSnapshot corp = new KillSnapshot();
		KillSnapshot crazyArchaeologist = new KillSnapshot();
		KillSnapshot dagPrime = new KillSnapshot();
		KillSnapshot dagRex = new KillSnapshot();
		KillSnapshot dagSupreme = new KillSnapshot();
		KillSnapshot derangedArch = new KillSnapshot();
		KillSnapshot generalGraardor = new KillSnapshot();
		KillSnapshot giantMole = new KillSnapshot();
		KillSnapshot grotesqueGuardians = new KillSnapshot();
		KillSnapshot hespori = new KillSnapshot();
		KillSnapshot kalphiteQueen = new KillSnapshot();
		KillSnapshot kbd = new KillSnapshot();
		KillSnapshot kraken = new KillSnapshot();
		KillSnapshot kreearra = new KillSnapshot();
		KillSnapshot krilTstsaroth = new KillSnapshot();
		KillSnapshot mimic = new KillSnapshot();
		KillSnapshot nightmare = new KillSnapshot();
		KillSnapshot phosani = new KillSnapshot();
		KillSnapshot obor = new KillSnapshot();
		KillSnapshot sarachnis = new KillSnapshot();
		KillSnapshot scorpia = new KillSnapshot();
		KillSnapshot skotizo = new KillSnapshot();
		KillSnapshot tempoross = new KillSnapshot();
		KillSnapshot theGauntlet = new KillSnapshot();
		KillSnapshot theGauntletCorrupted = new KillSnapshot();
		KillSnapshot tob = new KillSnapshot();
		KillSnapshot tobHard = new KillSnapshot();
		KillSnapshot thermie = new KillSnapshot();
		KillSnapshot zuk = new KillSnapshot();
		KillSnapshot jad = new KillSnapshot();
		KillSnapshot venenatis = new KillSnapshot();
		KillSnapshot vetion = new KillSnapshot();
		KillSnapshot vorkath = new KillSnapshot();
		KillSnapshot wintertodt = new KillSnapshot();
		KillSnapshot zalcano = new KillSnapshot();
		KillSnapshot zulrah = new KillSnapshot();
		EfficiencySnapshot efficiencySnapshot = new EfficiencySnapshot();
		for (String s : snapshotLines) {
			switch (ln) {
				case 1 -> snapshot.createdAt = s.split(":")[1];
				case 2 -> snapshot.importedAt = getValue(s);
				case 3 -> {
					overallSnapshot.skill = Skill.OVERALL;
					overallSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 4 ->	overallSnapshot.xp = Long.parseLong(s.split(":")[1]);
				case 5 ->	overallSnapshot.ehp = Double.parseDouble(s.split(":")[1]);
				case 6 -> {
					attackSnapshot.skill = Skill.ATTACK;
					attackSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 7 ->	attackSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 8 -> {
					defenceSnapshot.skill = Skill.DEFENCE;
					defenceSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 9 ->	defenceSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 10 -> {
					strengthSnapshot.skill = Skill.STRENGTH;
					strengthSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 11 ->	strengthSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 12 -> {
					hitpointsSnapshot.skill = Skill.HITPOINTS;
					hitpointsSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 13 ->	hitpointsSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 14 -> {
					rangedSnapshot.skill = Skill.RANGED;
					rangedSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 15 ->	rangedSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 16 -> {
					prayerSnapshot.skill = Skill.PRAYER;
					prayerSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 17 ->	prayerSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 18 -> {
					magicSnapshot.skill = Skill.MAGIC;
					magicSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 19	->  magicSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 20 -> {
					cookingSnapshot.skill = Skill.COOKING;
					cookingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 21 ->	cookingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 22 -> {
					woodcuttingSnapshot.skill = Skill.WOODCUTTING;
					woodcuttingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 23 ->	woodcuttingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 24 -> {
					fletchingSnapshot.skill = Skill.FLETCHING;
					fletchingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 25 ->	fletchingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 26 -> {
					fishingSnapshot.skill = Skill.FISHING;
					fishingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 27 ->	fishingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 28 -> {
					firemakingSnapshot.skill = Skill.FIREMAKING;
					firemakingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 29 ->	firemakingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 30 -> {
					craftingSnapshot.skill = Skill.CRAFTING;
					craftingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 31 ->	craftingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 32 -> {
					smithingSnapshot.skill = Skill.SMITHING;
					smithingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 33 ->	smithingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 34 -> {
					miningSnapshot.skill = Skill.MINING;
					miningSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 35 ->	miningSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 36 -> {
					herbloreSnapshot.skill = Skill.HERBLORE;
					herbloreSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 37 ->	herbloreSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 38 -> {
					agilitySnapshot.skill = Skill.AGILITY;
					agilitySnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 39 ->	agilitySnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 40 -> {
					thievingSnapshot.skill = Skill.THIEVING;
					thievingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 41 ->	thievingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 42 -> {
					slayerSnapshot.skill = Skill.SLAYER;
					slayerSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 43 ->	slayerSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 44 -> {
					farmingSnapshot.skill = Skill.FARMING;
					farmingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 45 ->	farmingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 46 -> {
					runecraftingSnapshot.skill = Skill.RUNECRAFT;
					runecraftingSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 47 ->	runecraftingSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 48 -> {
					hunterSnapshot.skill = Skill.HUNTER;
					hunterSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 49 ->	hunterSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 50 -> {
					constructionSnapshot.skill = Skill.CONSTRUCTION;
					constructionSnapshot.rank = Integer.parseInt(s.split(":")[2]);
				}
				case 51 ->	constructionSnapshot.xp = Integer.parseInt(s.split(":")[1]);
				case 52 -> 	leaguePoints.rank = Integer.parseInt(s.split(":")[2]);
				case 53 -> 	leaguePoints.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 54 -> 	leaguePoints.rank = Integer.parseInt(s.split(":")[2]);
				case 55 -> 	leaguePoints.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 56 -> 	bountyHunterHunter.rank = Integer.parseInt(s.split(":")[2]);
				case 57 -> 	bountyHunterHunter.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 58 -> 	bountyHunterRogue.rank = Integer.parseInt(s.split(":")[2]);
				case 59 -> 	bountyHunterRogue.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 60 -> 	clueScrollsAll.rank = Integer.parseInt(s.split(":")[2]);
				case 61 -> 	clueScrollsAll.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 62 -> 	clueScrollsEasy.rank = Integer.parseInt(s.split(":")[2]);
				case 63 -> 	clueScrollsEasy.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 64 -> 	clueScrollsMed.rank = Integer.parseInt(s.split(":")[2]);
				case 65 -> 	clueScrollsMed.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 66 -> 	clueScrollsHard.rank = Integer.parseInt(s.split(":")[2]);
				case 67 -> 	clueScrollsHard.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 68 -> 	clueScrollsElite.rank = Integer.parseInt(s.split(":")[2]);
				case 69 -> 	clueScrollsElite.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 70 -> 	clueScrollsMaster.rank = Integer.parseInt(s.split(":")[2]);
				case 71 -> 	clueScrollsMaster.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 72 -> 	lastManStanding.rank = Integer.parseInt(s.split(":")[2]);
				case 73 -> 	lastManStanding.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 74 -> 	soulWarsZeal.rank = Integer.parseInt(s.split(":")[2]);
				case 75 -> 	soulWarsZeal.score = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 76 -> 	abyssalSire.rank = Integer.parseInt(s.split(":")[2]);
				case 77 -> 	abyssalSire.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 78 -> 	alchemicalHydra.rank = Integer.parseInt(s.split(":")[2]);
				case 79 -> 	alchemicalHydra.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 80 -> 	barrowsChests.rank = Integer.parseInt(s.split(":")[2]);
				case 81 -> 	barrowsChests.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 82 -> 	bryophyta.rank = Integer.parseInt(s.split(":")[2]);
				case 83 -> 	bryophyta.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 84 -> 	callisto.rank = Integer.parseInt(s.split(":")[2]);
				case 85 -> 	callisto.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 86 -> 	cerberus.rank = Integer.parseInt(s.split(":")[2]);
				case 87 -> 	cerberus.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 88 -> 	cox.rank = Integer.parseInt(s.split(":")[2]);
				case 89 -> 	cox.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 90 -> 	coxChallenge.rank = Integer.parseInt(s.split(":")[2]);
				case 91 -> 	coxChallenge.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 92 -> 	chaosElemental.rank = Integer.parseInt(s.split(":")[2]);
				case 93 -> 	chaosElemental.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 94 -> 	chaosFanatic.rank = Integer.parseInt(s.split(":")[2]);
				case 95 -> 	chaosFanatic.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 96 -> 	commanderZilyana.rank = Integer.parseInt(s.split(":")[2]);
				case 97 -> 	commanderZilyana.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 98 -> 	corp.rank = Integer.parseInt(s.split(":")[2]);
				case 99 -> 	corp.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 100 -> 	crazyArchaeologist.rank = Integer.parseInt(s.split(":")[2]);
				case 101 -> 	crazyArchaeologist.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 102 -> 	dagPrime.rank = Integer.parseInt(s.split(":")[2]);
				case 103 -> 	dagPrime.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 104 -> 	dagRex.rank = Integer.parseInt(s.split(":")[2]);
				case 105 -> 	dagRex.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 106 -> 	dagSupreme.rank = Integer.parseInt(s.split(":")[2]);
				case 107 -> 	dagSupreme.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 108 -> 	derangedArch.rank = Integer.parseInt(s.split(":")[2]);
				case 109 -> 	derangedArch.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 110 -> 	generalGraardor.rank = Integer.parseInt(s.split(":")[2]);
				case 111 -> 	generalGraardor.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 112 -> 	giantMole.rank = Integer.parseInt(s.split(":")[2]);
				case 113 -> 	giantMole.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 114 -> 	grotesqueGuardians.rank = Integer.parseInt(s.split(":")[2]);
				case 115 -> 	grotesqueGuardians.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 116 -> 	hespori.rank = Integer.parseInt(s.split(":")[2]);
				case 117 -> 	hespori.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 118 -> 	kalphiteQueen.rank = Integer.parseInt(s.split(":")[2]);
				case 119 -> 	kalphiteQueen.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 120 -> 	kbd.rank = Integer.parseInt(s.split(":")[2]);
				case 121 -> 	kbd.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 122 -> 	kraken.rank = Integer.parseInt(s.split(":")[2]);
				case 123 -> 	kraken.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 124 -> 	kreearra.rank = Integer.parseInt(s.split(":")[2]);
				case 125 -> 	kreearra.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 126 -> 	krilTstsaroth.rank = Integer.parseInt(s.split(":")[2]);
				case 127 -> 	krilTstsaroth.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 128 -> 	mimic.rank = Integer.parseInt(s.split(":")[2]);
				case 129 -> 	mimic.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 130 -> 	nightmare.rank = Integer.parseInt(s.split(":")[2]);
				case 131 -> 	nightmare.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 132 -> 	phosani.rank = Integer.parseInt(s.split(":")[2]);
				case 133 -> 	phosani.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 134 -> 	obor.rank = Integer.parseInt(s.split(":")[2]);
				case 135 -> 	obor.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 136 -> 	sarachnis.rank = Integer.parseInt(s.split(":")[2]);
				case 137 -> 	sarachnis.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 138 -> 	scorpia.rank = Integer.parseInt(s.split(":")[2]);
				case 139 -> 	scorpia.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 140 -> 	skotizo.rank = Integer.parseInt(s.split(":")[2]);
				case 141 -> 	skotizo.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 142 -> 	tempoross.rank = Integer.parseInt(s.split(":")[2]);
				case 143 -> 	tempoross.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 144 -> 	theGauntlet.rank = Integer.parseInt(s.split(":")[2]);
				case 145 -> 	theGauntlet.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 146 -> 	theGauntletCorrupted.rank = Integer.parseInt(s.split(":")[2]);
				case 147 -> 	theGauntletCorrupted.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 148 -> 	tob.rank = Integer.parseInt(s.split(":")[2]);
				case 149 -> 	tob.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 150 -> 	tobHard.rank = Integer.parseInt(s.split(":")[2]);
				case 151 -> 	tobHard.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 152 -> 	thermie.rank = Integer.parseInt(s.split(":")[2]);
				case 153 -> 	thermie.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 154 -> 	zuk.rank = Integer.parseInt(s.split(":")[2]);
				case 155 -> 	zuk.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 156 -> 	jad.rank = Integer.parseInt(s.split(":")[2]);
				case 157 -> 	jad.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 158 -> 	venenatis.rank = Integer.parseInt(s.split(":")[2]);
				case 159 -> 	venenatis.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 160 -> 	vetion.rank = Integer.parseInt(s.split(":")[2]);
				case 161 -> 	vetion.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 162 -> 	vorkath.rank = Integer.parseInt(s.split(":")[2]);
				case 163 -> 	vorkath.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 164 -> 	wintertodt.rank = Integer.parseInt(s.split(":")[2]);
				case 165 -> 	wintertodt.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 166 -> 	zalcano.rank = Integer.parseInt(s.split(":")[2]);
				case 167 -> 	zalcano.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
				case 168 -> 	zulrah.rank = Integer.parseInt(s.split(":")[2]);
				case 169 -> 	zulrah.kills = Math.max(0, Integer.parseInt(s.split(":")[1]));
			}
			ln++;
		}
		snapshot.overall = overallSnapshot;
		snapshot.attack = attackSnapshot;
		snapshot.defence = defenceSnapshot;
		snapshot.strength = strengthSnapshot;
		snapshot.hitpoints = hitpointsSnapshot;
		snapshot.ranged = rangedSnapshot;
		snapshot.prayer = prayerSnapshot;
		snapshot.magic = magicSnapshot;
		snapshot.cooking = cookingSnapshot;
		snapshot.woodcutting = woodcuttingSnapshot;
		snapshot.fletching = fletchingSnapshot;
		snapshot.fishing = fishingSnapshot;
		snapshot.firemaking = firemakingSnapshot;
		snapshot.crafting = craftingSnapshot;
		snapshot.smithing = smithingSnapshot;
		snapshot.mining = miningSnapshot;
		snapshot.herblore = herbloreSnapshot;
		snapshot.agility = agilitySnapshot;
		snapshot.thieving = thievingSnapshot;
		snapshot.slayer = slayerSnapshot;
		snapshot.farming = farmingSnapshot;
		snapshot.runecrafting = runecraftingSnapshot;
		snapshot.hunter = hunterSnapshot;
		snapshot.construction = constructionSnapshot;
		snapshot.abyssalSire = abyssalSire;
		return snapshot;
	}
	public String getValue(String entry) {
		return entry.split(":")[1];
	}
}
