package com.blundell.tut;

import android.util.Log;

public class LoggingGpioProxy implements GpioProxy {

    @Override
    public void writeRowAddress(int rowAddress) {
        log("rowAddress : " + rowAddress);
        log("value : " + ((rowAddress & 8) == 8));
        log("value : " + ((rowAddress & 4) == 4));
        log("value : " + ((rowAddress & 2) == 2));
        log("value : " + ((rowAddress & 1) == 1));
    }

    private void log(String msg) {
        Log.d("TUT", msg);
    }

    @Override
    public void writePixelsSequence(byte pins) {
        log("pins : " + pins);
        log("value : " + ((pins & 100_000) == 100_000));
        log("value : " + ((pins & 10_000) == 10_000));
        log("value : " + ((pins & 1_000) == 1_000));
        log("value : " + ((pins & 100) == 100));
        log("value : " + ((pins & 10) == 10));
        log("value : " + ((pins & 1) == 1));
    }

    @Override
    public void writePixel(RGBmatrixPanel.PixelPins pins) {
        log("pins : " + pins);
        log("value : " + pins.r1);
        log("value : " + pins.g1);
        log("value : " + pins.b1);
        log("value : " + pins.r1);
        log("value : " + pins.g2);
        log("value : " + pins.b2);
    }

    @Override
    public void writeClock(boolean value) {
        log("set clock : " + value);
    }

    @Override
    public void writeOutputEnabled(boolean value) {
        log("set output enabled : " + value);
    }

    @Override
    public void writeLatch(boolean value) {
        log("set latch : " + value);
    }
}
