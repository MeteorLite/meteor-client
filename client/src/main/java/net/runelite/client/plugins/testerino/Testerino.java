package net.runelite.client.plugins.testerino;
import eventbus.events.GameTick;
import meteor.api.items.Items;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import net.runelite.api.InventoryID;
import org.jetbrains.annotations.NotNull;

@PluginDescriptor(
        name = "Testerino",
        description = "Test plugin",
        enabledByDefault = false
)
public class Testerino extends Plugin
{
    public static meteor.Logger log = new meteor.Logger("Testerino");
    private TesterinoConfig config = (TesterinoConfig) javaConfiguration(TesterinoConfig.class);
    private int eaten = 0;

    @Override
    public void onGameTick(@NotNull GameTick it)
    {
       log.info("hello world from testerino 1234");
       var cake = Items.INSTANCE.getFirst(new String[]{"Cake"}, InventoryID.INVENTORY);
       if (cake != null && eaten < 2) {
           cake.interact("Eat");
           eaten++;
       }
    }
}
