/*
 * Copyright (c) 2021, Zoinkwiz <https://github.com/Zoinkwiz>
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
package com.questhelper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import meteor.config.ConfigManager;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.WorldType;

@Slf4j
public class QuestBank
{
	private final ConfigManager configManager;
	private final Client client;
	private final Gson gson;

	private static final String CONFIG_GROUP = "questhelper";
	private static final String BANK_KEY = "bankitems";

	private List<Item> bankItems;
	private String rsProfileKey;

	public List<WorldType> worldTypes = Arrays.asList(WorldType.SEASONAL, WorldType.TOURNAMENT_WORLD,
		WorldType.DEADMAN, WorldType.NOSAVE_MODE);

	public QuestBank(Client client, ConfigManager configManager, Gson gson)
	{
		this.configManager = configManager;
		this.client = client;
		this.gson = gson;
		this.bankItems = new ArrayList<>();
	}

	public void updateLocalBank(Item[] items)
	{
		bankItems = Arrays.asList(items);
	}

	public List<Item> getBankItems()
	{
		return bankItems;
	}

	public void emptyState()
	{
		rsProfileKey = null;
		bankItems = new ArrayList<>();
	}

	public void loadState()
	{
		saveBankToConfig();
		loadBankFromConfig();
	}

	private void loadBankFromConfig()
	{
		// Remove deprecated config
		configManager.unsetConfiguration(CONFIG_GROUP, getCurrentKey());
		List<Item> storedItems = gson.fromJson(
			configManager.getConfiguration(CONFIG_GROUP, BANK_KEY),
			new TypeToken<List<Item>>(){}.getType());
		if (storedItems != null)
		{
			bankItems = storedItems;
		}
		else
		{
			bankItems = new ArrayList<>();
		}
	}

	public void saveBankToConfig()
	{
		if (rsProfileKey == null)
		{
			return;
		}
		configManager.setConfiguration(CONFIG_GROUP, BANK_KEY, gson.toJson(bankItems));
	}

	private String getCurrentKey()
	{
		StringBuilder key = new StringBuilder();
		EnumSet<WorldType> worldType = client.getWorldType();
		for (WorldType type : worldType)
		{
			if (worldTypes.contains(type))
				key.append(type.name()).append(":");
		}
		if (client.getLocalPlayer() == null)
		{
			return "NULL PLAYER";
		}
		key.append(client.getLocalPlayer().getName());
		return key.toString();
	}
}
