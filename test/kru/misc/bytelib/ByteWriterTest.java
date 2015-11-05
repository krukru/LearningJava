package kru.misc.bytelib;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ByteWriterTest {

  private ByteWriter bw = new ByteWriter();

  @Test
  public void testWrite() throws Exception {
    char[] data = new char[]{0x55, 0x7c};
    char[] result = bw.write(data, 7);
    assertArrayEquals(new char[]{0xab, 0xf0}, result);
  }
}