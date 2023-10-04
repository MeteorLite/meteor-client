package mixins;

import net.runelite.api.mixins.*;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGameShell;

import java.awt.*;

@Mixin(RSGameShell.class)
public abstract class StretchedModeMaxSizeMixin implements RSGameShell
{
	@Shadow("mudClient")
	private static RSClient client;



}
