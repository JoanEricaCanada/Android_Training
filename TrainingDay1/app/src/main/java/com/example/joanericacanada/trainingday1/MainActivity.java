package com.example.joanericacanada.trainingday1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        /*ViewHolder hold = new ViewHolder();
        hold.editTxt = (EditText)findViewById(R.id.editText);
        hold.txtView = (TextView)findViewById(R.id.textView2);
        hold.button = (Button)findViewById(R.id.button9);
        hold.chkBox = (CheckBox)findViewById(R.id.checkBox2);*/
    }

    static class ViewHolder{
        EditText editTxt;
        TextView txtView;
        Button button;
        CheckBox chkBox;
    }
}
