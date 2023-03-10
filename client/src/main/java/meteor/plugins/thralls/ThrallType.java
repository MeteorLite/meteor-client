package meteor.plugins.thralls;

import dev.hoot.api.magic.Necromancy;
import lombok.Getter;

/**
 * @author Hayden#7709
 */
@Getter
public enum ThrallType {

	LESSER_GHOST(Necromancy.RESURRECT_LESSER_GHOST),
	LESSER_SKELETON(Necromancy.RESURRECT_LESSER_SKELETON),
	LESSER_ZOMBIE(Necromancy.RESURRECT_LESSER_ZOMBIE),
	SUPERIOR_GHOST(Necromancy.RESURRECT_SUPERIOR_GHOST),
	SUPERIOR_SKELETON(Necromancy.RESURRECT_SUPERIOR_SKELETON),
	SUPERIOR_ZOMBIE(Necromancy.RESURRECT_SUPERIOR_ZOMBIE),
	GREATER_GHOST(Necromancy.RESURRECT_GREATER_GHOST),
	GREATER_SKELETON(Necromancy.RESURRECT_GREATER_SKELETON),
	GREATER_ZOMBIE(Necromancy.RESURRECT_GREATER_ZOMBIE);

	private final Necromancy spellToCast;

	ThrallType(Necromancy spellToCast) {
		this.spellToCast = spellToCast;
	}
}