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

@Import("field2463")
@Override
RSClientPacket OPLOCU();

@Import("field2502")
@Override
RSClientPacket IF_BUTTON2();

@Import("field2443")
@Override
RSClientPacket IF1_BUTTON2();

@Import("field2427")
@Override
RSClientPacket BUTTON_CLICK();

@Import("field2431")
@Override
RSClientPacket OPNPC2();

@Import("field2433")
@Override
RSClientPacket OPLOC5();

@Import("field2425")
@Override
RSClientPacket IF_BUTTON7();

@Import("field2426")
@Override
RSClientPacket OPPLAYERU();

@Import("field2440")
@Override
RSClientPacket OPLOC1();

@Import("field2441")
@Override
RSClientPacket IF_BUTTON8();

@Import("field2435")
@Override
RSClientPacket OPOBJT();

@Import("field2475")
@Override
RSClientPacket IF_BUTTON6();

@Import("field2444")
@Override
RSClientPacket IF_BUTTON9();

@Import("field2437")
@Override
RSClientPacket IF1_BUTTON1();

@Import("field2450")
@Override
RSClientPacket OPOBJU();

@Import("field2451")
@Override
RSClientPacket IF1_BUTTON4();

@Import("field2452")
@Override
RSClientPacket OPHELDT();

@Import("field2492")
@Override
RSClientPacket OPLOC4();

@Import("field2458")
@Override
RSClientPacket OPHELD2();

@Import("field2482")
@Override
RSClientPacket OPLOC3();

@Import("field2462")
@Override
RSClientPacket OPLOCT();

@Import("field2516")
@Override
RSClientPacket OPOBJ4();

@Import("field2464")
@Override
RSClientPacket OPNPC5();

@Import("field2465")
@Override
RSClientPacket OPPLAYERT();

@Import("field2423")
@Override
RSClientPacket OPHELDU();

@Import("field2469")
@Override
RSClientPacket OPOBJ3();

@Import("field2420")
@Override
RSClientPacket IF_BUTTON4();

@Import("field2471")
@Override
RSClientPacket REFLECTION_CHECK_REPLY();

@Import("field2442")
@Override
RSClientPacket IF_BUTTON10();

@Import("field2477")
@Override
RSClientPacket OPHELD5();

@Import("field2438")
@Override
RSClientPacket IF_BUTTON1();

@Import("field2480")
@Override
RSClientPacket IF_BUTTON5();

@Import("field2486")
@Override
RSClientPacket LOGIN_STATISTICS();

@Import("field2487")
@Override
RSClientPacket IF1_BUTTON5();

@Import("field2488")
@Override
RSClientPacket OPNPC3();

@Import("field2514")
@Override
RSClientPacket OPHELD4();

@Import("field2490")
@Override
RSClientPacket OPNPC4();

@Import("field2493")
@Override
RSClientPacket OPNPCT();

@Import("field2495")
@Override
RSClientPacket IF_BUTTON3();

@Import("field2496")
@Override
RSClientPacket OPOBJ1();

@Import("field2447")
@Override
RSClientPacket OPNPCU();

@Import("field2498")
@Override
RSClientPacket IF1_BUTTON3();

@Import("field2478")
@Override
RSClientPacket OPLOC2();

@Import("field2504")
@Override
RSClientPacket OPHELD3();

@Import("field2506")
@Override
RSClientPacket OPHELD1();

@Import("field2494")
@Override
RSClientPacket OPPLAYER1();

@Import("field2460")
@Override
RSClientPacket OPOBJ2();

@Import("field2512")
@Override
RSClientPacket OPNPC1();

}