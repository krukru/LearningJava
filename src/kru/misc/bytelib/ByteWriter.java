package kru.misc.bytelib;

public class ByteWriter {

  private static final int CHAR_BIT_SIZE = 8;

  public char[] write(char[] data, int numberOfSignificantBits) {
    if (numberOfSignificantBits <= 0 || numberOfSignificantBits > CHAR_BIT_SIZE) {
      throw new IllegalArgumentException();
    }
    double compressionFactor = (double) numberOfSignificantBits / CHAR_BIT_SIZE;
    int requiredMemorySize = (int) Math.ceil(data.length * compressionFactor);
    char[] result = new char[requiredMemorySize];
    write(data, result, numberOfSignificantBits);
    return result;
  }

  private void write(char[] data, char[] result, int numberOfSignificantBits) {
    int offset = CHAR_BIT_SIZE - numberOfSignificantBits;
    int numberOfSpareBits = 0;
    for (int i = 0; i < data.length; i++) {
      char actualData = (char) (data[i] << offset);
      if (numberOfSpareBits > 0) {
        char filterMask = (char) (0x80 >> (numberOfSpareBits - 1));
        char overflow = (char) (actualData & filterMask);
        char spareBits = (char) (overflow >>> (CHAR_BIT_SIZE - numberOfSpareBits));
        actualData = (char) (actualData << numberOfSpareBits); //this doesn't seem to overflow as expected
        result[i - 1] = (char) (result[i - 1] | spareBits);
      }
      numberOfSpareBits = (numberOfSpareBits + offset) % CHAR_BIT_SIZE;
      result[i] = actualData;
    }
  }
}
