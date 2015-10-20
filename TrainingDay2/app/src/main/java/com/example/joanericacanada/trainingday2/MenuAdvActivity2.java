package com.example.joanericacanada.trainingday2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by joanericacanada on 10/20/15.
 */
public class MenuAdvActivity2 extends Activity {
    TextView textView;
    CheckBox checkBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        textView = (TextView)findViewById(R.id.textView);
        checkBox = (CheckBox)findViewById(R.id.chbExtMenu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, checkBox.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
