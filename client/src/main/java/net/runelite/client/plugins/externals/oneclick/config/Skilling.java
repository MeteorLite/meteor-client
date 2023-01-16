package net.runelite.client.plugins.externals.oneclick.config;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.Birdhouses;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.Bones;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.HighAlch;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.Karams;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.Runes;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.Tiaras;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.farming.FarmingRun;
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.farming.TitheFarm;

@Getter
@AllArgsConstructor
public enum Skilling
{
	BIRDHOUSES(Birdhouses.class),
	BONES(Bones.class),
	FARMING_RUN(FarmingRun.class),
	HIGH_ALCH(HighAlch.class),
	KARAMBWANS(Karams.class),
	RUNES(Runes.class),
	TIARA(Tiaras.class),
	TITHE_FARM(TitheFarm.class),
	;

	private final Class<? extends Clickable> clazz;

	public static List<Clickable> createInstances(Skilling[] skillings)
	{
		Set<Skilling> set = Set.of(skillings);
		return set.stream()
			.filter(Objects::nonNull)
			.map(skilling -> {
				try {
					return skilling.getClazz().newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			})
			.collect(Collectors.toList());
	}
}
