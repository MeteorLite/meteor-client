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

  @Import("field3023")
  @Override
  RSClientPacket EVENT_KEYBOARD();

  @Import("field2939")
  @Override
  RSClientPacket BUTTON_CLICK();

  @Import("field2988")
  @Override
  RSClientPacket OPPLAYER8();

  @Import("field2960")
  @Override
  RSClientPacket REFLECTION_CHECK_REPLY();

  @Import("field2945")
  @Override
  RSClientPacket OPOBJ2();

  @Import("field3043")
  @Override
  RSClientPacket OPHELD5();

  @Import("field2949")
  @Override
  RSClientPacket OPNPCT();

  @Import("field2951")
  @Override
  RSClientPacket OPLOCU();

  @Import("field3044")
  @Override
  RSClientPacket OPNPC4();

  @Import("field3006")
  @Override
  RSClientPacket OPOBJT();

  @Import("field3041")
  @Override
  RSClientPacket OPLOC3();

  @Import("field2959")
  @Override
  RSClientPacket IF_BUTTON8();

  @Import("field2961")
  @Override
  RSClientPacket OPNPC2();

  @Import("field2941")
  @Override
  RSClientPacket OPNPC5();

  @Import("field2963")
  @Override
  RSClientPacket OPPLAYER3();

  @Import("field2964")
  @Override
  RSClientPacket IF_BUTTON1();

  @Import("field2973")
  @Override
  RSClientPacket OPPLAYER6();

  @Import("field2968")
  @Override
  RSClientPacket OPLOCT();

  @Import("field2975")
  @Override
  RSClientPacket OPPLAYER4();

  @Import("field2970")
  @Override
  RSClientPacket OPHELD2();

  @Import("field2971")
  @Override
  RSClientPacket OPLOC5();

  @Import("field2974")
  @Override
  RSClientPacket IF_BUTTON9();

  @Import("field2965")
  @Override
  RSClientPacket OPLOC2();

  @Import("field2958")
  @Override
  RSClientPacket OPNPCU();

  @Import("field2936")
  @Override
  RSClientPacket IF_BUTTON4();

  @Import("field2980")
  @Override
  RSClientPacket OPHELDU();

  @Import("field2981")
  @Override
  RSClientPacket OPPLAYER2();

  @Import("field2937")
  @Override
  RSClientPacket OPOBJ6();

  @Import("field2983")
  @Override
  RSClientPacket IF_BUTTON2();

  @Import("field2984")
  @Override
  RSClientPacket OPPLAYER5();

  @Import("field2985")
  @Override
  RSClientPacket OPPLAYERT();

  @Import("field2987")
  @Override
  RSClientPacket IF_BUTTONT();

  @Import("field3018")
  @Override
  RSClientPacket OPPLAYERU();

  @Import("field2992")
  @Override
  RSClientPacket OPHELD4();

  @Import("field2993")
  @Override
  RSClientPacket OPHELD3();

  @Import("field3045")
  @Override
  RSClientPacket OPOBJ5();

  @Import("field2996")
  @Override
  RSClientPacket OPLOC6();

  @Import("field2997")
  @Override
  RSClientPacket OPPLAYER7();

  @Import("field2999")
  @Override
  RSClientPacket IF1_BUTTON4();

  @Import("field3001")
  @Override
  RSClientPacket OPHELD1();

  @Import("field2969")
  @Override
  RSClientPacket OPNPC1();

  @Import("field2954")
  @Override
  RSClientPacket OPOBJ4();

  @Import("field3007")
  @Override
  RSClientPacket OPOBJU();

  @Import("field3010")
  @Override
  RSClientPacket IF_BUTTON10();

  @Import("field3011")
  @Override
  RSClientPacket OPPLAYER1();

  @Import("field3012")
  @Override
  RSClientPacket IF_BUTTON3();

  @Import("field3014")
  @Override
  RSClientPacket IF_BUTTON6();

  @Import("field3028")
  @Override
  RSClientPacket IF1_BUTTON1();

  @Import("field3017")
  @Override
  RSClientPacket IF_BUTTON7();

  @Import("field3019")
  @Override
  RSClientPacket IF1_BUTTON2();

  @Import("field2946")
  @Override
  RSClientPacket OPLOC4();

  @Import("field3032")
  @Override
  RSClientPacket IF1_BUTTON5();

  @Import("field3021")
  @Override
  RSClientPacket LOGIN_STATISTICS();

  @Import("field3026")
  @Override
  RSClientPacket OPOBJ3();

  @Import("field3027")
  @Override
  RSClientPacket IF_BUTTON5();

  @Import("field3029")
  @Override
  RSClientPacket OPOBJ1();

  @Import("field3033")
  @Override
  RSClientPacket MOVE_GAMECLICK();

  @Import("field3034")
  @Override
  RSClientPacket OPNPC3();

  @Import("field3035")
  @Override
  RSClientPacket OPNPC6();

  @Import("field3038")
  @Override
  RSClientPacket OPHELDT();

  @Import("field3039")
  @Override
  RSClientPacket EVENT_MOUSE_CLICK();

  @Import("field3040")
  @Override
  RSClientPacket IF1_BUTTON3();

  @Import("field3042")
  @Override
  RSClientPacket OPLOC1();

}