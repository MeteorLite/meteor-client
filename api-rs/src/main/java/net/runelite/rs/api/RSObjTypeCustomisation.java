package net.runelite.rs.api;

import net.runelite.api.ObjTypeCustomisation;
import net.runelite.mapping.Import;

public interface RSObjTypeCustomisation extends ObjTypeCustomisation
{
    @Import("recol")
    @Override
    short[] getColorToReplaceWith();

    @Import("retex")
    @Override
    short[] getTextureToReplaceWith();
}
