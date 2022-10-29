package net.runelite.rs.api;

import net.runelite.api.packets.ClientPacket;
import net.runelite.mapping.Import;

public interface RSClientPacket extends ClientPacket
{
@Import("id")
@Override
int getId();

@Import("length")
@Override
int getLength();

@Import("field2998")
@Override
RSClientPacket OPHELDT();

@Import("field3001")
@Override
RSClientPacket OPPLAYER3();

@Import("field3002")
@Override
RSClientPacket IF_BUTTON10();

@Import("field3004")
@Override
RSClientPacket EVENT_KEYBOARD();

@Import("field3005")
@Override
RSClientPacket OPNPC5();

@Import("field3007")
@Override
RSClientPacket OPLOC3();

@Import("field3042")
@Override
RSClientPacket IF_BUTTON3();

@Import("field3010")
@Override
RSClientPacket OPLOC4();

@Import("field3011")
@Override
RSClientPacket OPOBJ4();

@Import("field3012")
@Override
RSClientPacket IF_BUTTON1();

@Import("field3013")
@Override
RSClientPacket OPNPC3();

@Import("field3014")
@Override
RSClientPacket OPOBJU();

@Import("field3015")
@Override
RSClientPacket IF_BUTTON4();

@Import("field3025")
@Override
RSClientPacket IF_BUTTON5();

@Import("field3082")
@Override
RSClientPacket OPHELD5();

@Import("field3018")
@Override
RSClientPacket IF_BUTTON9();

@Import("field3019")
@Override
RSClientPacket IF_BUTTON8();

@Import("field3049")
@Override
RSClientPacket OPOBJ3();

@Import("field3021")
@Override
RSClientPacket OPLOC5();

@Import("field3024")
@Override
RSClientPacket OPHELD1();

@Import("field3023")
@Override
RSClientPacket LOGIN_STATISTICS();

@Import("field3041")
@Override
RSClientPacket OPOBJ5();

@Import("field3063")
@Override
RSClientPacket OPOBJ2();

@Import("field3000")
@Override
RSClientPacket REFLECTION_CHECK_REPLY();

@Import("field3033")
@Override
RSClientPacket IF_BUTTON2();

@Import("field3027")
@Override
RSClientPacket OPPLAYER6();

@Import("field3083")
@Override
RSClientPacket OPLOC6();

@Import("field3095")
@Override
RSClientPacket OPOBJ6();

@Import("field3047")
@Override
RSClientPacket OPPLAYER2();

@Import("field3043")
@Override
RSClientPacket IF1_BUTTON1();

@Import("field3044")
@Override
RSClientPacket OPOBJT();

@Import("field3046")
@Override
RSClientPacket OPPLAYER7();

@Import("field3003")
@Override
RSClientPacket IF_BUTTON6();

@Import("field3050")
@Override
RSClientPacket OPLOCT();

@Import("field3051")
@Override
RSClientPacket EVENT_MOUSE_CLICK();

@Import("field3052")
@Override
RSClientPacket OPPLAYER8();

@Import("field3053")
@Override
RSClientPacket OPHELDU();

@Import("field3088")
@Override
RSClientPacket IF_BUTTONT();

@Import("field3055")
@Override
RSClientPacket IF1_BUTTON3();

@Import("field3026")
@Override
RSClientPacket OPNPC1();

@Import("field3060")
@Override
RSClientPacket IF1_BUTTON4();

@Import("field3061")
@Override
RSClientPacket OPHELD2();

@Import("field3035")
@Override
RSClientPacket OPNPC4();

@Import("field3064")
@Override
RSClientPacket OPHELD4();

@Import("field3067")
@Override
RSClientPacket OPPLAYER1();

@Import("field3068")
@Override
RSClientPacket OPNPCU();

@Import("field3048")
@Override
RSClientPacket OPHELD3();

@Import("field3073")
@Override
RSClientPacket IF_BUTTON7();

@Import("field3076")
@Override
RSClientPacket OPNPCT();

@Import("field3029")
@Override
RSClientPacket IF1_BUTTON2();

@Import("field3078")
@Override
RSClientPacket OPLOC1();

@Import("field3079")
@Override
RSClientPacket OPNPC2();

@Import("field3080")
@Override
RSClientPacket OPLOCU();

@Import("field3017")
@Override
RSClientPacket OPNPC6();

@Import("field2996")
@Override
RSClientPacket BUTTON_CLICK();

@Import("field3087")
@Override
RSClientPacket IF1_BUTTON5();

@Import("field2999")
@Override
RSClientPacket OPPLAYER4();

@Import("field3089")
@Override
RSClientPacket OPLOC2();

@Import("field3091")
@Override
RSClientPacket MOVE_GAMECLICK();

@Import("field3098")
@Override
RSClientPacket OPPLAYER5();

@Import("field3100")
@Override
RSClientPacket OPPLAYERU();

@Import("field3037")
@Override
RSClientPacket OPOBJ1();

@Import("field3102")
@Override
RSClientPacket OPPLAYERT();

}