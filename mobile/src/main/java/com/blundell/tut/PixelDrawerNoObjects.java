package com.blundell.tut;

class PixelDrawerNoObjects implements PixelDrawer {

    private final int width;
    private final int height;
    private final int pwmBits;
    private final byte[][][] plane;

    PixelDrawerNoObjects(int width, int height, int pwmBits,
                         byte[][][] plane) {
        this.width = width;
        this.height = height;
        this.pwmBits = pwmBits;
        this.plane = plane;
    }

    @Override
    public void drawPixel(int col, int row, int color) {
        if (col >= width || row >= height) {
            return;
        }

        // Four 32x32 panels would be connected like:  [>] [>]
        //                                             [<] [<]
        // Which would be 64 columns and 32 rows from L to R, then flipping backwards
        // for the next 32 rows (and 64 columns).
        if (row > 31) {
            col = (byte) (127 - col);
            row = (byte) (63 - row);
        }

        // Break out values from structure
        int red = android.graphics.Color.red(color);
        int green = android.graphics.Color.green(color);
        int blue = android.graphics.Color.blue(color);

        //TODO: Adding Gamma correction slowed down the PWM and made
        //      the matrix flicker, so I'm removing it for now.

        // Gamma correct
        //red   = pgm_read_byte(&Gamma[red]);
        //green = pgm_read_byte(&Gamma[green]);
        //blue  = pgm_read_byte(&Gamma[blue]);

        // Scale to the number of bit planes, so MSB matches MSB of PWM.
        red >>= 8 - pwmBits;
        green >>= 8 - pwmBits;
        blue >>= 8 - pwmBits;

        // Set RGB pins for this pixel in each PWM bit plane.
        for (int b = 0; b < pwmBits; b++) {
            writePixel(col, row, red, green, blue, b);
        }
    }

    private void writePixel(int x, int y, int red, int green, int blue, int b) {
        byte mask = (byte) (1 << b);
        byte pins = plane[b][y & 0xf][x];

        if (y < 16) {
            // Upper sub-panel
            pins |= ((red & mask) == mask ? 1 : 0) << 1;
            pins |= ((green & mask) == mask ? 1 : 0) << 2;
            pins |= ((blue & mask) == mask ? 1 : 0) << 3;
        } else {
            // Lower sub-panel
            pins |= ((red & mask) == mask ? 1 : 0) << 4;
            pins |= ((green & mask) == mask ? 1 : 0) << 5;
            pins |= ((blue & mask) == mask ? 1 : 0) << 6;
        }
        plane[b][y & 0xf][x] = pins;
    }
}
