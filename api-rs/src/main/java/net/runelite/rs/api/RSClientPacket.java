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

@Import("field2480")
@Override
RSClientPacket OPPLAYERT();

@Import("field2432")
@Override
RSClientPacket EVENT_KEYBOARD();

@Import("field2433")
@Override
RSClientPacket OPHELDT();

@Import("field2445")
@Override
RSClientPacket OPLOCU();

@Import("field2455")
@Override
RSClientPacket OPOBJ4();

@Import("field2444")
@Override
RSClientPacket IF_BUTTON1();

@Import("field2437")
@Override
RSClientPacket OPNPCT();

@Import("field2537")
@Override
RSClientPacket IF_BUTTONT();

@Import("field2494")
@Override
RSClientPacket OPLOC1();

@Import("field2448")
@Override
RSClientPacket OPLOCT();

@Import("field2450")
@Override
RSClientPacket OPPLAYER6();

@Import("field2451")
@Override
RSClientPacket OPNPC5();

@Import("field2452")
@Override
RSClientPacket OPNPC2();

@Import("field2454")
@Override
RSClientPacket IF_BUTTON3();

@Import("field2440")
@Override
RSClientPacket IF1_BUTTON4();

@Import("field2456")
@Override
RSClientPacket IF_BUTTON5();

@Import("field2458")
@Override
RSClientPacket IF_BUTTON8();

@Import("field2465")
@Override
RSClientPacket IF_BUTTON10();

@Import("field2463")
@Override
RSClientPacket IF_BUTTON7();

@Import("field2464")
@Override
RSClientPacket OPOBJ3();

@Import("field2524")
@Override
RSClientPacket OPNPC3();

@Import("field2466")
@Override
RSClientPacket OPNPCU();

@Import("field2496")
@Override
RSClientPacket OPLOC4();

@Import("field2489")
@Override
RSClientPacket OPPLAYER7();

@Import("field2472")
@Override
RSClientPacket OPPLAYER5();

@Import("field2475")
@Override
RSClientPacket OPPLAYER1();

@Import("field2453")
@Override
RSClientPacket OPOBJU();

@Import("field2477")
@Override
RSClientPacket OPHELD3();

@Import("field2431")
@Override
RSClientPacket OPPLAYER4();

@Import("field2479")
@Override
RSClientPacket OPHELD1();

@Import("field2482")
@Override
RSClientPacket IF_BUTTON6();

@Import("field2484")
@Override
RSClientPacket OPOBJ2();

@Import("field2485")
@Override
RSClientPacket OPHELD2();

@Import("field2486")
@Override
RSClientPacket OPNPC4();

@Import("field2506")
@Override
RSClientPacket OPHELD4();

@Import("field2488")
@Override
RSClientPacket OPHELD5();

@Import("field2498")
@Override
RSClientPacket EVENT_MOUSE_CLICK();

@Import("field2490")
@Override
RSClientPacket OPLOC2();

@Import("field2535")
@Override
RSClientPacket OPLOC6();

@Import("field2495")
@Override
RSClientPacket IF1_BUTTON5();

@Import("field2517")
@Override
RSClientPacket BUTTON_CLICK();

@Import("field2460")
@Override
RSClientPacket IF_BUTTON9();

@Import("field2500")
@Override
RSClientPacket IF1_BUTTON3();

@Import("field2501")
@Override
RSClientPacket OPOBJ1();

@Import("field2503")
@Override
RSClientPacket OPLOC5();

@Import("field2522")
@Override
RSClientPacket OPPLAYER8();

@Import("field2512")
@Override
RSClientPacket IF_BUTTON4();

@Import("field2470")
@Override
RSClientPacket OPPLAYERU();

@Import("field2515")
@Override
RSClientPacket OPHELDU();

@Import("field2516")
@Override
RSClientPacket OPOBJ6();

@Import("field2523")
@Override
RSClientPacket IF1_BUTTON2();

@Import("field2478")
@Override
RSClientPacket OPPLAYER3();

@Import("field2446")
@Override
RSClientPacket OPLOC3();

@Import("field2521")
@Override
RSClientPacket OPNPC1();

@Import("field2443")
@Override
RSClientPacket IF1_BUTTON1();

@Import("field2467")
@Override
RSClientPacket MOVE_GAMECLICK();

@Import("field2520")
@Override
RSClientPacket REFLECTION_CHECK_REPLY();

@Import("field2527")
@Override
RSClientPacket LOGIN_STATISTICS();

@Import("field2528")
@Override
RSClientPacket IF_BUTTON2();

@Import("field2531")
@Override
RSClientPacket OPPLAYER2();

@Import("field2487")
@Override
RSClientPacket OPNPC6();

@Import("field2536")
@Override
RSClientPacket OPOBJT();

}