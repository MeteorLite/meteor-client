package net.runelite.client.plugins.oneclick3t4g;

import eventbus.events.ChatMessage;
import eventbus.events.ClientTick;
import eventbus.events.MenuOptionClicked;
import meteor.Main;
import meteor.api.Items;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.plugins.PluginManager;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.widgets.WidgetInfo;

import java.util.ArrayList;
import java.util.List;

import static net.runelite.api.MenuAction.*;

@PluginDescriptor(
        name = "One Click 3t4g",
        description = "mines granite efficiently in 1 click. YOU NEED A KNIFE AND TEAK LOG",
        enabledByDefault = false
)
public class OneClick3t4g extends Plugin {
    private OneClick3t4gConfig config = configuration(OneClick3t4gConfig.class);

    private Client client = Main.INSTANCE.getClient();
    private int startingTickCount=-1;
    int stage = 0;
    private int currentRock=0;
    List<GameObject> rocks = new ArrayList<>();

    @Override
    public void onStop(){
        reset();
    }
    @Override
    public void onStart(){
        reset();
    }
    public void reset(){
        startingTickCount = client.getTickCount();
        stage =0;
        rocks = new ArrayList<>();
    }
    @Override
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
        if(event.getMenuOption().contains("one click 3t4g")) {
            clickHandler(event);
        }
        if(event.getMenuOption().contains("one click 3t4g")) {
            event.consume();
        }
    }
    public void clickHandler(MenuOptionClicked event) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }
        if(config.humidify()){
            if(Items.INSTANCE.getFirst(new int[] {1825,1827,1829,1823}, InventoryID.INVENTORY)==null){
                if(Items.INSTANCE.getFirst(new int[] {1831}, InventoryID.INVENTORY)!=null){
                    event.setMenuEntry(client.createMenuEntry("Cast","<col=00ff00>Humidify</col>",1,CC_OP.getId(),-1, client.getWidget(WidgetInfo.SPELL_HUMIDIFY).getId(),false));
                }else{
                    client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "you need to bring waterskins for this disabling plugin", null);
                    PluginManager.INSTANCE.toggle(this);
                }
                return;
            }
        }
        if(!Items.INSTANCE.inventoryContains(6333)||!Items.INSTANCE.inventoryContains(946)){
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "you need to bring a teak log and knife. disabling plugin", null);
            PluginManager.INSTANCE.toggle(this);
            return;
        }
        if(rocks.size()==0) {
            GameObject rock1 = new GameObjectQuery().atWorldLocation(new WorldPoint(3165,2908,0)).result(client).first();
            GameObject rock2 = new GameObjectQuery().atWorldLocation(new WorldPoint(3165,2909,0)).result(client).first();
            GameObject rock3 = new GameObjectQuery().atWorldLocation(new WorldPoint(3165,2910,0)).result(client).first();
            GameObject rock4 = new GameObjectQuery().atWorldLocation(new WorldPoint(3167,2911,0)).result(client).first();
            if(rock1==null||rock2==null||rock3==null||rock4==null){
                client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "you need to be at the 3t4g spot. disabling plugin", null);
                PluginManager.INSTANCE.toggle(this);
                return;
            }
            rocks.add(rock1);
            rocks.add(rock2);
            rocks.add(rock3);
            rocks.add(rock4);
            return;
        }
        if(startingTickCount==-1||(client.getTickCount()-startingTickCount)>2){
            if(config.humidify()){
                if(Items.INSTANCE.getFirst(new int[] {1825,1827,1829,1823}, InventoryID.INVENTORY)==null){
                    if(Items.INSTANCE.getFirst(new int[] {1831}, InventoryID.INVENTORY)!=null){
                        event.setMenuEntry(client.createMenuEntry("Cast","<col=00ff00>Humidify</col>",1,CC_OP.getId(),-1,14286958,false));
                    }else{
                        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "you need to bring waterskins for this disabling plugin", null);
                        PluginManager.INSTANCE.toggle(this);
                    }
                    return;
                }
            }
            Item knife = getItem(946);
            Item teak = getItem(6333);
            if(teak==null){
                return;
            }
            if(knife!=null) {
                event.setSelectedItemIndex(knife.getSlot());
                client.setSelectedSpellWidget(WidgetInfo.INVENTORY.getPackedId());
                client.setSelectedSpellItemId(knife.getId());
                client.setSelectedSpellChildIndex(knife.getSlot());
                stage = 1;
                event.setMenuEntry(client.createMenuEntry("Use", "<col=ff9040>Knife<col=ffffff> -> <col=ff9040>Teak logs", 6333, WIDGET_TARGET_ON_WIDGET.getId(), teak.getSlot(), 9764864, false));
                startingTickCount = client.getTickCount();
                return;
            }
        }
        if(client.getTickCount()==startingTickCount){
            if(stage==1){
                event.setMenuEntry(client.createMenuEntry("Mine", "<col=ffff>Rocks", 11387, GAME_OBJECT_FIRST_OPTION.getId(),rocks.get(currentRock).getLocalLocation().getSceneX() , rocks.get(currentRock).getLocalLocation().getSceneY(), false));
                currentRock++;
                if(currentRock==4){
                    currentRock=0;
                }
                stage++;
            }
        }else if(client.getTickCount()==(startingTickCount+1)){
            if(stage==2){
                if (getItem(6979) != null) {
                    Item granite = getItem(6979);
                    if(granite==null){
                        return;
                    }
                    event.setMenuEntry(client.createMenuEntry("Drop", "<col=ff9040>Granite (500g)", granite.getId(), ITEM_FIFTH_OPTION.getId(), granite.getSlot(), 9764864, false));
                    stage=3;
                } else if (getItem(6981) != null) {
                    Item granite = getItem(6981);
                    if(granite==null){
                        return;
                    }
                    event.setMenuEntry(client.createMenuEntry("Drop", "<col=ff9040>Granite (2kg)", granite.getId(), ITEM_FIFTH_OPTION.getId(), granite.getSlot(), 9764864, false));
                    stage=3;
                } else if (getItem(6983) != null) {
                    Item granite = getItem(6983);
                    if(granite==null){
                        return;
                    }
                    event.setMenuEntry(client.createMenuEntry("Drop", "<col=ff9040>Granite (5kg)", granite.getId(), ITEM_FIFTH_OPTION.getId(), granite.getSlot(), 9764864, false));
                    stage=3;
                }
            }else if(stage!=3){
                if(config.humidify()){
                    if(!Items.INSTANCE.inventoryContains(1825)&&!Items.INSTANCE.inventoryContains(1827)||!Items.INSTANCE.inventoryContains(1829)||!Items.INSTANCE.inventoryContains(1823)){
                        if(Items.INSTANCE.inventoryContains(1831)){
                            event.setMenuEntry(client.createMenuEntry("Cast","<col=00ff00>Humidify</col>",1,CC_OP.getId(),-1,14286958,false));
                        }else{
                            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "you need to bring waterskins for this disabling plugin", null);
                            PluginManager.INSTANCE.toggle(this);
                            return;
                        }
                    }
                }
                Item knife = getItem(946);
                Item teak = getItem(6333);
                if(teak==null){
                    return;
                }
                if(knife!=null) {
                    event.setSelectedItemIndex(knife.getSlot());
                    client.setSelectedSpellWidget(WidgetInfo.INVENTORY.getPackedId());
                    client.setSelectedSpellItemId(knife.getId());
                    client.setSelectedSpellChildIndex(knife.getSlot());
                    stage = 1;
                    event.setMenuEntry(client.createMenuEntry("Use", "<col=ff9040>Knife<col=ffffff> -> <col=ff9040>Teak logs", 6333, WIDGET_TARGET_ON_WIDGET.getId(), teak.getSlot(), 9764864, false));
                    startingTickCount = client.getTickCount();
                }
            }
        }else if(client.getTickCount()==(startingTickCount+2)){
            if(stage==2){
                return;
            }
            if(stage==3){
                if(currentRock==0){
                    currentRock=4;
                }
                event.setMenuEntry(client.createMenuEntry("Mine", "<col=ffff>Rocks", 11387, GAME_OBJECT_FIRST_OPTION.getId(),rocks.get(currentRock-1).getLocalLocation().getSceneX() , rocks.get(currentRock-1).getLocalLocation().getSceneY(), false));
                stage=0;
                if(currentRock==4){
                    currentRock=0;
                }
            }
        }
    }
    @Override
    public void onChatMessage(ChatMessage message){
        if(message.getMessage().contains("You do not have enough")){
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "you had no humidify runes. disabling plugin", null);
            PluginManager.INSTANCE.toggle(this);
        }
    }
    private Item getItem(int id) {
        return Items.INSTANCE.getFirst(new int[]{id}, InventoryID.INVENTORY);
    }

    @Override
    public void onClientTick(ClientTick event)
    {
        if(client.getLocalPlayer() == null || client.getGameState() != GameState.LOGGED_IN){
            return;
        }
        client.insertMenuItem("one click 3t4g", "", 0, 0, 0, 0, true);
    }
}
