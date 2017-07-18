package com.blundell.tut;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

public class HaxActivity extends Activity {

    private Handler handler;
    private RGBmatrixPanel rgbMatrixPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("!!!", "I'm running");

        HandlerThread thread = new HandlerThread("BackgroundThread");
        thread.start();
        handler = new Handler(thread.getLooper());

        rgbMatrixPanel = new RGBmatrixPanel(new AndroidThingsGpioProxy());
//        rgbMatrixPanel.clearDisplay();
        handler.post(hax);

        Tests.drawWholeScreen(rgbMatrixPanel);
//        Tests.drawThreeSquares(rgbMatrixPanel);
//        Tests.writeHelloWorld(rgbMatrixPanel);
    }

    private final Runnable hax = new Runnable() {
        @Override
        public void run() {
//            TimingLogger logger = new TimingLogger("RGB", "run");
//            logger.addSplit("update display");
            rgbMatrixPanel.updateDisplay();
//            logger.addSplit("updated display");
            handler.post(this);
//            logger.dumpToLog();
        }
    };

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(hax);
        super.onDestroy();
    }
}

