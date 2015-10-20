package com.example.joanericacanada.trainingday2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by joanericacanada on 10/20/15.
 */
public class MenuAdvActivity extends Activity {
    TextView textView;
    CheckBox checkBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        textView = (TextView)findViewById(R.id.textView);
        checkBox = (CheckBox)findViewById(R.id.chbExtMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 4, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(1, checkBox.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Item Menu")
                .append("\r\n groupId: " + String.valueOf(item.getGroupId()))
                .append("\r\n itemId: " + String.valueOf(item.getItemId()))
                .append("\r\n order: " + String.valueOf(item.getOrder()))
                .append("\r\n title: " + item.getTitle());

        textView.setText(stringBuilder.toString());

        return super.onOptionsItemSelected(item);
    }
}
