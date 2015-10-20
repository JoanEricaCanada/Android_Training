package com.example.joanericacanada.trainingday2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joanericacanada on 10/20/15.
 */
public class HelloWorldApp extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        final TextView textView = (TextView)findViewById(R.id.tv_View);
        final EditText editText = (EditText)findViewById(R.id.et_Text);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
                        textView.setText(textView.getText() + ", " + editText.getText());
                        editText.setText(" ");
                        return true;
                    }
                    /*textView.setText(textView.getText() + ", " + editText.getText());
                    editText.setText("");
                    return true;*/
                }
                    return false;
            }
        });

    }
}
