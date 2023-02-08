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

@Import("field2430")
@Override
RSClientPacket OPLOC5();

@Import("field2433")
@Override
RSClientPacket OPOBJ4();

@Import("field2445")
@Override
RSClientPacket OPNPC4();

@Import("field2440")
@Override
RSClientPacket OPPLAYER8();

@Import("field2444")
@Override
RSClientPacket OPLOC4();

@Import("field2437")
@Override
RSClientPacket OPNPCU();

@Import("field2447")
@Override
RSClientPacket IF_BUTTON3();

@Import("field2449")
@Override
RSClientPacket OPNPC6();

@Import("field2451")
@Override
RSClientPacket IF_BUTTON4();

@Import("field2452")
@Override
RSClientPacket OPOBJ1();

@Import("field2509")
@Override
RSClientPacket IF_BUTTON10();

@Import("field2456")
@Override
RSClientPacket OPHELDU();

@Import("field2457")
@Override
RSClientPacket LOGIN_STATISTICS();

@Import("field2531")
@Override
RSClientPacket BUTTON_CLICK();

@Import("field2438")
@Override
RSClientPacket OPPLAYER7();

@Import("field2513")
@Override
RSClientPacket OPNPC1();

@Import("field2467")
@Override
RSClientPacket IF1_BUTTON3();

@Import("field2450")
@Override
RSClientPacket OPPLAYER1();

@Import("field2461")
@Override
RSClientPacket OPLOC3();

@Import("field2470")
@Override
RSClientPacket OPOBJ2();

@Import("field2530")
@Override
RSClientPacket OPHELD4();

@Import("field2473")
@Override
RSClientPacket IF1_BUTTON5();

@Import("field2476")
@Override
RSClientPacket OPPLAYERU();

@Import("field2478")
@Override
RSClientPacket OPPLAYER6();

@Import("field2479")
@Override
RSClientPacket OPPLAYER5();

@Import("field2448")
@Override
RSClientPacket OPHELDT();

@Import("field2484")
@Override
RSClientPacket IF_BUTTON2();

@Import("field2485")
@Override
RSClientPacket OPLOCU();

@Import("field2486")
@Override
RSClientPacket IF_BUTTON8();

@Import("field2488")
@Override
RSClientPacket OPNPC2();

@Import("field2489")
@Override
RSClientPacket OPPLAYERT();

@Import("field2491")
@Override
RSClientPacket IF_BUTTON1();

@Import("field2492")
@Override
RSClientPacket OPNPC5();

@Import("field2493")
@Override
RSClientPacket IF1_BUTTON4();

@Import("field2446")
@Override
RSClientPacket OPOBJ3();

@Import("field2497")
@Override
RSClientPacket IF_BUTTONT();

@Import("field2499")
@Override
RSClientPacket OPNPC3();

@Import("field2500")
@Override
RSClientPacket REFLECTION_CHECK_REPLY();

@Import("field2504")
@Override
RSClientPacket IF_BUTTON6();

@Import("field2505")
@Override
RSClientPacket OPHELD5();

@Import("field2507")
@Override
RSClientPacket IF_BUTTON7();

@Import("field2429")
@Override
RSClientPacket OPLOC6();

@Import("field2510")
@Override
RSClientPacket IF1_BUTTON2();

@Import("field2511")
@Override
RSClientPacket OPLOCT();

@Import("field2518")
@Override
RSClientPacket IF_BUTTON5();

@Import("field2529")
@Override
RSClientPacket OPOBJ6();

@Import("field2517")
@Override
RSClientPacket OPPLAYER4();

@Import("field2462")
@Override
RSClientPacket OPHELD3();

@Import("field2474")
@Override
RSClientPacket IF1_BUTTON1();

@Import("field2520")
@Override
RSClientPacket OPHELD2();

@Import("field2521")
@Override
RSClientPacket OPPLAYER2();

@Import("field2524")
@Override
RSClientPacket OPOBJU();

@Import("field2525")
@Override
RSClientPacket OPPLAYER3();

@Import("field2475")
@Override
RSClientPacket OPLOC2();

@Import("field2480")
@Override
RSClientPacket IF_BUTTON9();

@Import("field2506")
@Override
RSClientPacket OPHELD1();

@Import("field2533")
@Override
RSClientPacket OPLOC1();

@Import("field2471")
@Override
RSClientPacket OPOBJT();

@Import("field2536")
@Override
RSClientPacket OPNPCT();

}