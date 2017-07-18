package com.blundell.tut;

import android.graphics.Color;

public class Tests {

    public static void drawWholeScreen(RGBmatrixPanel rgbMatrixPanel) {
        for (int col = 0; col < RGBmatrixPanel.WIDTH; col++) {
            for (int row = 0; row < RGBmatrixPanel.HEIGHT; row++) {
                rgbMatrixPanel.drawPixel(row, col, Color.WHITE);
            }
        }
    }

    public static void drawThreeSquares(RGBmatrixPanel rgbMatrixPanel) {
        // A square
        rgbMatrixPanel.drawPixel(3, 3, Color.YELLOW);
        rgbMatrixPanel.drawPixel(4, 3, Color.RED);
        rgbMatrixPanel.drawPixel(5, 3, Color.YELLOW);
        rgbMatrixPanel.drawPixel(6, 3, Color.RED);
        rgbMatrixPanel.drawPixel(7, 3, Color.YELLOW);
        rgbMatrixPanel.drawPixel(8, 3, Color.RED);
        rgbMatrixPanel.drawPixel(9, 3, Color.YELLOW);

        rgbMatrixPanel.drawPixel(3, 3, Color.RED);
        rgbMatrixPanel.drawPixel(3, 4, Color.YELLOW);
        rgbMatrixPanel.drawPixel(3, 5, Color.RED);
        rgbMatrixPanel.drawPixel(3, 6, Color.YELLOW);
        rgbMatrixPanel.drawPixel(3, 7, Color.RED);
        rgbMatrixPanel.drawPixel(3, 8, Color.YELLOW);
        rgbMatrixPanel.drawPixel(3, 9, Color.RED);

        rgbMatrixPanel.drawPixel(9, 3, Color.YELLOW);
        rgbMatrixPanel.drawPixel(9, 4, Color.RED);
        rgbMatrixPanel.drawPixel(9, 5, Color.YELLOW);
        rgbMatrixPanel.drawPixel(9, 6, Color.RED);
        rgbMatrixPanel.drawPixel(9, 7, Color.YELLOW);
        rgbMatrixPanel.drawPixel(9, 8, Color.RED);
        rgbMatrixPanel.drawPixel(9, 9, Color.YELLOW);

        rgbMatrixPanel.drawPixel(3, 9, Color.RED);
        rgbMatrixPanel.drawPixel(4, 9, Color.YELLOW);
        rgbMatrixPanel.drawPixel(5, 9, Color.RED);
        rgbMatrixPanel.drawPixel(6, 9, Color.YELLOW);
        rgbMatrixPanel.drawPixel(7, 9, Color.RED);
        rgbMatrixPanel.drawPixel(8, 9, Color.YELLOW);
        rgbMatrixPanel.drawPixel(9, 9, Color.RED);

        // A square
        rgbMatrixPanel.drawPixel(13, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(14, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(15, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(16, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(17, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(18, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 13, Color.GREEN);

        rgbMatrixPanel.drawPixel(13, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(13, 14, Color.GREEN);
        rgbMatrixPanel.drawPixel(13, 15, Color.GREEN);
        rgbMatrixPanel.drawPixel(13, 16, Color.GREEN);
        rgbMatrixPanel.drawPixel(13, 17, Color.GREEN);
        rgbMatrixPanel.drawPixel(13, 18, Color.GREEN);
        rgbMatrixPanel.drawPixel(13, 19, Color.GREEN);

        rgbMatrixPanel.drawPixel(19, 13, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 14, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 15, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 16, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 17, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 18, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 19, Color.GREEN);

        rgbMatrixPanel.drawPixel(13, 19, Color.GREEN);
        rgbMatrixPanel.drawPixel(14, 19, Color.GREEN);
        rgbMatrixPanel.drawPixel(15, 19, Color.GREEN);
        rgbMatrixPanel.drawPixel(16, 19, Color.GREEN);
        rgbMatrixPanel.drawPixel(17, 19, Color.GREEN);
        rgbMatrixPanel.drawPixel(18, 19, Color.GREEN);
        rgbMatrixPanel.drawPixel(19, 19, Color.GREEN);

        // A square
        rgbMatrixPanel.drawPixel(23, 23, Color.RED);
        rgbMatrixPanel.drawPixel(24, 23, Color.GREEN);
        rgbMatrixPanel.drawPixel(25, 23, Color.BLUE);
        rgbMatrixPanel.drawPixel(26, 23, Color.RED);
        rgbMatrixPanel.drawPixel(27, 23, Color.GREEN);
        rgbMatrixPanel.drawPixel(28, 23, Color.BLUE);
        rgbMatrixPanel.drawPixel(29, 23, Color.RED);

        rgbMatrixPanel.drawPixel(23, 23, Color.RED);
        rgbMatrixPanel.drawPixel(23, 24, Color.GREEN);
        rgbMatrixPanel.drawPixel(23, 25, Color.BLUE);
        rgbMatrixPanel.drawPixel(23, 26, Color.RED);
        rgbMatrixPanel.drawPixel(23, 27, Color.GREEN);
        rgbMatrixPanel.drawPixel(23, 28, Color.BLUE);
        rgbMatrixPanel.drawPixel(23, 29, Color.RED);

        rgbMatrixPanel.drawPixel(29, 23, Color.RED);
        rgbMatrixPanel.drawPixel(29, 24, Color.GREEN);
        rgbMatrixPanel.drawPixel(29, 25, Color.BLUE);
        rgbMatrixPanel.drawPixel(29, 26, Color.RED);
        rgbMatrixPanel.drawPixel(29, 27, Color.GREEN);
        rgbMatrixPanel.drawPixel(29, 28, Color.BLUE);
        rgbMatrixPanel.drawPixel(29, 29, Color.RED);

        rgbMatrixPanel.drawPixel(23, 29, Color.RED);
        rgbMatrixPanel.drawPixel(24, 29, Color.GREEN);
        rgbMatrixPanel.drawPixel(25, 29, Color.BLUE);
        rgbMatrixPanel.drawPixel(26, 29, Color.RED);
        rgbMatrixPanel.drawPixel(27, 29, Color.GREEN);
        rgbMatrixPanel.drawPixel(28, 29, Color.BLUE);
        rgbMatrixPanel.drawPixel(29, 29, Color.RED);
    }

    public static void writeHelloWorld(RGBmatrixPanelNoObjects rgbMatrixPanel) {
        rgbMatrixPanel.setFontColor(Color.BLUE);
        rgbMatrixPanel.writeText("Hello World");
    }
}
