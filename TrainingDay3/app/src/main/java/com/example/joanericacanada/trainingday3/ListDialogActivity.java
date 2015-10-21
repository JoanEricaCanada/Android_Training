package com.example.joanericacanada.trainingday3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by joanericacanada on 10/21/15.
 */
public class ListDialogActivity extends Activity implements View.OnClickListener{

    private TextView textView;
    private String[] color = {"Red", "Blue", "Green"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_dialog_layout);

        textView = (TextView)findViewById(R.id.textView);
        Button btnColorChange = (Button)findViewById(R.id.button2);
        btnColorChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle(R.string.me)
                .setItems(color, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0: textView.setTextColor(Color.RED); break;
                            case 1: textView.setTextColor(Color.BLUE); break;
                            case 2: textView.setTextColor(Color.GREEN); break;
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
