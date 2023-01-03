package net.runelite.rs.api;

import net.runelite.api.KeyFocusListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import net.runelite.mapping.Import;

public interface RSKeyHandler extends KeyListener, FocusListener, KeyFocusListener {
  @Import("KeyHandler_idleCycles")
  int getIdleCycles$api();

  @Import("KeyHandler_idleCycles")
  void setIdleCycles(int i);

  @Import("KeyHandler_pressedKeys")
  boolean[] getPressedKeys();
}
