package kru.honi.round1;

import kru.collections.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class AkcijaTest {

  private Akcija akcija = new Akcija();

  @Test
  public void testGetTotalPrice() throws Exception {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(475);
    list.add(66);
    list.add(701);
    list.add(860);
    list.add(421);
    list.add(205);
    list.add(606);
    list.add(159);
    list.add(354);
    list.add(709);
    list.add(217);
    list.add(391);
    list.add(512);
    list.add(559);
    list.add(50);
    list.add(333);
    list.add(559);
    list.add(170);
    list.add(838);
    list.add(430);
    list.add(564);
    list.add(193);
    list.add(90);
    list.add(652);
    list.add(781);
    list.add(855);
    list.add(831);
    list.add(868);
    list.add(670);
    list.add(91);
    list.add(852);
    list.add(673);
    list.add(236);
    list.add(847);
    list.add(444);
    list.add(513);
    list.add(720);
    list.add(171);
    list.add(210);
    list.add(190);
    list.add(134);
    list.add(951);
    list.add(26);
    list.add(64);
    list.add(343);
    list.add(145);
    list.add(370);
    list.add(946);
    list.add(28);
    list.add(900);
    list.add(841);
    list.add(938);
    list.add(492);
    list.add(394);
    list.add(398);
    list.add(812);
    list.add(7);
    list.add(818);
    list.add(612);
    list.add(505);
    list.add(579);
    list.add(861);
    list.add(765);
    list.add(540);
    list.add(7);
    list.add(710);
    list.add(461);
    list.add(733);
    list.add(95);
    list.add(353);
    list.add(528);
    list.add(682);
    list.add(127);
    list.add(870);
    list.add(710);
    list.add(387);
    list.add(91);
    list.add(549);
    list.add(533);
    list.add(908);
    list.add(663);
    list.add(643);
    list.add(944);
    list.add(928);
    list.add(530);
    list.add(798);
    list.add(400);
    list.add(892);
    list.add(152);
    list.add(966);
    list.add(80);
    list.add(146);
    list.add(657);
    list.add(93);
    list.add(69);
    list.add(976);
    list.add(996);
    list.add(760);
    list.add(773);
    list.add(408);
    assertEquals(34439, akcija.getTotalPrice(list));
  }
}

