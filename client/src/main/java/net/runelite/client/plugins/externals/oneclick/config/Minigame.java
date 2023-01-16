package net.runelite.client.plugins.externals.oneclick.config;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable;
import net.runelite.client.plugins.externals.oneclick.clickables.minigames.Healers;
import net.runelite.client.plugins.externals.oneclick.clickables.minigames.TroubleBrewing;

@Getter
@AllArgsConstructor
public enum Minigame
{
	BA_HEALERS(Healers.class),
	TR_BREWING(TroubleBrewing.class),
	MTA(net.runelite.client.plugins.externals.oneclick.clickables.minigames.MTA.class),
	;
	private final Class<? extends Clickable> clazz;

	public static List<Clickable> createInstances(Minigame[] minigames)
	{
		Set<Minigame> set = Set.of(minigames);
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
