package com.blundell.tut;

class PixelDrawerDisplayPlane implements PixelDrawer {

    private final int width;
    private final int height;
    private final int pwmBits;
    private final RGBmatrixPanel.Display[] plane;

    PixelDrawerDisplayPlane(int width, int height, int pwmBits, RGBmatrixPanel.Display[] plane) {
        this.width = width;
        this.height = height;
        this.pwmBits = pwmBits;
        this.plane = plane;
    }

    @Override
    public void drawPixel(int x, int y, int color) {
        if (x >= width || y >= height) {
            return;
        }

        // Four 32x32 panels would be connected like:  [>] [>]
        //                                             [<] [<]
        // Which would be 64 columns and 32 rows from L to R, then flipping backwards
        // for the next 32 rows (and 64 columns).
        if (y > 31) {
            x = (byte) (127 - x);
            y = (byte) (63 - y);
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
            byte mask = (byte) (1 << b);
            RGBmatrixPanel.PixelPins pins = plane[b].row[y & 0xf].column[x];

            if (y < 16) {
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
}
