package com.neonsnake.game;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/** Shows the game (assets/index.html) in a full-window WebView. */
public class MainActivity extends Activity {

    // Back: running game -> pause, paused or finished game -> main menu.
    // Returns false on the main menu, where Back closes the app.
    private static final String BACK_JS =
            "(function(){"
            + "var g=document.getElementById('game');"
            + "if(!g||g.hidden)return false;"
            + "var p=document.getElementById('paused'),e=document.getElementById('ended');"
            + "if(!p.hidden)document.getElementById('pauseMenu').click();"
            + "else if(!e.hidden)document.getElementById('endMenu').click();"
            + "else document.getElementById('pause').click();"
            + "return true;"
            + "})()";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        webView.setBackgroundColor(Color.parseColor("#111613"));
        webView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // Needed for localStorage: best score, pace and sound setting.
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setTextZoom(100);

        setContentView(webView);

        if (savedInstanceState == null) {
            webView.loadUrl("file:///android_asset/index.html");
        } else {
            webView.restoreState(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    protected void onPause() {
        webView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    public void onBackPressed() {
        webView.evaluateJavascript(BACK_JS, value -> {
            if (!"true".equals(value)) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        webView.destroy();
        super.onDestroy();
    }
}
