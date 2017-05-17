package com.wei.qrcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_SCANER_RESULT = 1;
    private final String TAG = getClass().getSimpleName();
    private EditText resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTxt = (EditText) findViewById(R.id.edtTxt_result);
    }

    public void scan(View view)
    {
        startActivityForResult(new Intent(this, ScanerActivity.class), REQUEST_SCANER_RESULT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d(TAG, "onActivityResult " + requestCode + "　result " + resultCode);
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_SCANER_RESULT && resultCode == Activity.RESULT_OK) {
            Bundle data = intent.getExtras();
            if (data != null) {
                String code = data.getString(ScanerActivity.KEY_SCAN_RESULT);
                Log.d(TAG, "扫描结果: " + code);
                resultTxt.setText(code);
            }
        }
    }
}
