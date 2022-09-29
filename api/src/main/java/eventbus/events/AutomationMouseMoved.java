package eventbus.events;

import lombok.Value;
import net.runelite.api.Point;

@Value
public class AutomationMouseMoved {
  public Point point;
}
