package com.blundell.tut;

class PixelDrawerDisplayPlane implements PixelDrawer {

    private final int width;
    private final int height;
    private final int pwmBits;
    private final RGBmatrixPanelObjects.Display[] plane;

    PixelDrawerDisplayPlane(int width, int height, int pwmBits, RGBmatrixPanelObjects.Display[] plane) {
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
            col = 127 - col;
            row = 63 - row;
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
            writePixel(row, col, red, green, blue, b);
        }
    }

    private void writePixel(int row, int col, int red, int green, int blue, int b) {
        byte mask = (byte) (1 << b);
        RGBmatrixPanelObjects.PixelPins pins = plane[b].row[row & 0xf].column[col];

        if (row < 16) {
            // Upper sub-panel
            pins.r1 = ((red & mask) == mask);
            pins.g1 = ((green & mask) == mask);
            pins.b1 = ((blue & mask) == mask);
        } else {
            // Lower sub-panel
            pins.r2 = ((red & mask) == mask);
            pins.g2 = ((green & mask) == mask);
            pins.b2 = ((blue & mask) == mask);
        }
    }
}
