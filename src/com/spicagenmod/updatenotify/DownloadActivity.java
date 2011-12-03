package com.spicagenmod.updatenotify;

import java.util.ArrayList;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DownloadActivity extends Activity {
    private static final String TAG = "SMUpdateNotify-DownloadActivity";

    private TextView mNewVersionTextView;
    private TextView mOldVersionTextView;

    private Button mDownloadButton;

    private String mNewVersion;
    private String mOldVersion;
    private String mURL;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        mURL = extras.getString("url");
        mNewVersion = extras.getString("newVersion");
        mOldVersion = extras.getString("oldVersion");

        mNewVersionTextView = (TextView) findViewById(R.id.txt_new_version);
        mOldVersionTextView = (TextView) findViewById(R.id.txt_current_version);

        mDownloadButton = (Button) findViewById(R.id.btn_download);
        mDownloadButton.setOnClickListener(mDownloadListener);

        mNewVersionTextView.setText(mNewVersion);
        mOldVersionTextView.setText(mOldVersion);

        clearNotification();
    }

    private void clearNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(0);
    }


    private OnClickListener mDownloadListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "Starting download: " + mURL);

            //Intent i = new Intent();
            //i.setClassName("com.spicagenmod.updatenotify", "com.spicagenmod.updatenotify.DownloadService");
            //i.putExtra("rompackage", getRomPackage(mNewVersion, mURL));
            //startService(i);
            finish();
        }
    };
}
