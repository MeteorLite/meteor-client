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

    @Import("field3096")
    @Override
    RSClientPacket OPPLAYERT();

    @Import("field3049")
    @Override
    RSClientPacket OPHELDT();

    @Import("field3061")
    @Override
    RSClientPacket OPLOCU();

    @Import("field3071")
    @Override
    RSClientPacket OPOBJ4();

    @Import("field3060")
    @Override
    RSClientPacket IF_BUTTON1();

    @Import("field3053")
    @Override
    RSClientPacket OPNPCT();

    @Import("field3153")
    @Override
    RSClientPacket IF_BUTTONT();

    @Import("field3110")
    @Override
    RSClientPacket OPLOC1();

    @Import("field3064")
    @Override
    RSClientPacket OPLOCT();

    @Import("field3066")
    @Override
    RSClientPacket OPPLAYER6();

    @Import("field3067")
    @Override
    RSClientPacket OPNPC5();

    @Import("field3068")
    @Override
    RSClientPacket OPNPC2();

    @Import("field3070")
    @Override
    RSClientPacket IF_BUTTON3();

    @Import("field3056")
    @Override
    RSClientPacket IF1_BUTTON4();

    @Import("field3072")
    @Override
    RSClientPacket IF_BUTTON5();

    @Import("field3074")
    @Override
    RSClientPacket IF_BUTTON8();

    @Import("field3081")
    @Override
    RSClientPacket IF_BUTTON10();

    @Import("field3079")
    @Override
    RSClientPacket IF_BUTTON7();

    @Import("field3080")
    @Override
    RSClientPacket OPOBJ3();

    @Import("field3140")
    @Override
    RSClientPacket OPNPC3();

    @Import("field3082")
    @Override
    RSClientPacket OPNPCU();

    @Import("field3112")
    @Override
    RSClientPacket OPLOC4();

    @Import("field3105")
    @Override
    RSClientPacket OPPLAYER7();

    @Import("field3088")
    @Override
    RSClientPacket OPPLAYER5();

    @Import("field3091")
    @Override
    RSClientPacket OPPLAYER1();

    @Import("field3069")
    @Override
    RSClientPacket OPOBJU();

    @Import("field3093")
    @Override
    RSClientPacket OPHELD3();

    @Import("field3047")
    @Override
    RSClientPacket OPPLAYER4();

    @Import("field3095")
    @Override
    RSClientPacket OPHELD1();

    @Import("field3098")
    @Override
    RSClientPacket IF_BUTTON6();

    @Import("field3100")
    @Override
    RSClientPacket OPOBJ2();

    @Import("field3101")
    @Override
    RSClientPacket OPHELD2();

    @Import("field3102")
    @Override
    RSClientPacket OPNPC4();

    @Import("field3122")
    @Override
    RSClientPacket OPHELD4();

    @Import("field3104")
    @Override
    RSClientPacket OPHELD5();

    @Import("field3106")
    @Override
    RSClientPacket OPLOC2();

    @Import("field3151")
    @Override
    RSClientPacket OPLOC6();

    @Import("field3111")
    @Override
    RSClientPacket IF1_BUTTON5();

    @Import("field3133")
    @Override
    RSClientPacket BUTTON_CLICK();

    @Import("field3076")
    @Override
    RSClientPacket IF_BUTTON9();

    @Import("field3116")
    @Override
    RSClientPacket IF1_BUTTON3();

    @Import("field3117")
    @Override
    RSClientPacket OPOBJ1();

    @Import("field3119")
    @Override
    RSClientPacket OPLOC5();

    @Import("field3138")
    @Override
    RSClientPacket OPPLAYER8();

    @Import("field3128")
    @Override
    RSClientPacket IF_BUTTON4();

    @Import("field3086")
    @Override
    RSClientPacket OPPLAYERU();

    @Import("field3131")
    @Override
    RSClientPacket OPHELDU();

    @Import("field3132")
    @Override
    RSClientPacket OPOBJ6();

    @Import("field3139")
    @Override
    RSClientPacket IF1_BUTTON2();

    @Import("field3094")
    @Override
    RSClientPacket OPPLAYER3();

    @Import("field3062")
    @Override
    RSClientPacket OPLOC3();

    @Import("field3137")
    @Override
    RSClientPacket OPNPC1();

    @Import("field3059")
    @Override
    RSClientPacket IF1_BUTTON1();

    @Import("field3136")
    @Override
    RSClientPacket REFLECTION_CHECK_REPLY();

    @Import("field3143")
    @Override
    RSClientPacket LOGIN_STATISTICS();

    @Import("field3144")
    @Override
    RSClientPacket IF_BUTTON2();

    @Import("field3147")
    @Override
    RSClientPacket OPPLAYER2();

    @Import("field3103")
    @Override
    RSClientPacket OPNPC6();

    @Import("field3152")
    @Override
    RSClientPacket OPOBJT();

}