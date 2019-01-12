package com.scanner.app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends Activity {

    private static final int REQUEST_CAMERA = 1;
    @SuppressLint("StaticFieldLeak")
    public static TextView resultTextview;
    public static TextView resultFormat;
    Button scan_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        resultTextview = findViewById(R.id.result_text);
        resultFormat = findViewById(R.id.result_format);
        scan_button = findViewById(R.id.btn_scan);

        scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ScanCodeActivity.class));
                requestPermissions();
            }
        });
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA},REQUEST_CAMERA);
    }
}
