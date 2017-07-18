package com.blundell.tut;

interface GpioProxy {
    void writeRowAddress(int rowAddress);

    void writePixelsSequence(byte pins);

    void writePixel(RGBmatrixPanel.PixelPins pins);

    void writeClock(boolean value);

    void writeOutputEnabled(boolean value);

    void writeLatch(boolean value);
}
