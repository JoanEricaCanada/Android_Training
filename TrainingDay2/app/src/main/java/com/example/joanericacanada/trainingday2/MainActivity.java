package com.example.joanericacanada.trainingday2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    TextView txtViewOut;
    Button btnOK;
    Button btnCancel;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "find view elements");
        txtViewOut = (TextView)findViewById(R.id.tvOut);
        btnOK = (Button)findViewById(R.id.btnOk);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        Log.d(TAG, "assign listener to buttons");
        btnOK.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "define the button that invoked the listener by id");
        switch (v.getId()) {
            case R.id.btnOk:
                Log.d(TAG, "OK button");
                txtViewOut.setText("OK button was clicked");
                break;
            case R.id.btnCancel:
                Log.d(TAG, "Cancel button");
                txtViewOut.setText("Cancel button was clicked");
                break;
        }
    }
}
